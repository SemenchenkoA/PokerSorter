package com.sa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination {
    public enum PokerCombination{
        HI_CARD,
        PAIR,
        TWO_PAIR,
        TRIPLE,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_KIND,
        STRAIGHT_FLUSH;
    };

    public static PokerCombination detectCombination(PokerHand hand){
        String [] cardStrings = hand.getHand().split(" ");
        List<Card> cards = new ArrayList<>();

        for(String cardStr : cardStrings){
            cards.add(new Card(cardStr));
        }

        Collections.sort(cards, new CardByLabelComparator());

        boolean isAllSuitSame = true;
        boolean isHavePair = false;
        boolean isAllCardByOrder = true;

        Card card0 = cards.get(0);
        Suit suit0 = card0.getSuit();
        Card prevCard = card0;

        for(Card card : cards){
            Suit suit = card.getSuit();
            if(!suit.equals(suit0)){
                isAllSuitSame = false;
            }

            if(card != card0){
                int ord = prevCard.getLabel().ordinal() - card.getLabel().ordinal();

                if(ord != 1){
                    isAllCardByOrder = false;
                }
            }

            if(!isHavePair) {
                for (Card card1 : cards) {
                    if (card1 == card) continue;

                    if (card1.getLabel().equals(card.getLabel())) {
                        isHavePair = true;
                        break;
                    }
                }
            }

            prevCard = card;
        }

        int size = 13;
        int [] pool = new int[size];

        for(Card card : cards){
            pool[card.getLabel().ordinal()]++;
        }

        if(isAllSuitSame){
            if(isAllCardByOrder){
                return PokerCombination.STRAIGHT_FLUSH;
            }else {
                return PokerCombination.FLUSH;
            }
        }else{
            if(isAllCardByOrder){
                return PokerCombination.STRAIGHT;

            }else if(isHavePair){
                isHavePair = false;
                boolean isHaveTrips = false;
                boolean isHave2Pair = false;
                boolean isQuard = false;

                for(int c : pool){
                    switch (c){
                        case 4 -> isQuard = true;
                        case 2 -> {
                            if(isHavePair) isHave2Pair = true; else isHavePair = true;}
                        case 3 -> isHaveTrips = true;
                    }
                }

                if(isQuard){
                    return PokerCombination.FOUR_OF_KIND;
                }else if(isHavePair && isHaveTrips){
                    return PokerCombination.FULL_HOUSE;
                }else if(isHaveTrips){
                    return PokerCombination.TRIPLE;
                }else if(isHave2Pair){
                    return PokerCombination.TWO_PAIR;
                }else if(isHavePair){
                    return PokerCombination.PAIR;
                }

            }else{
                return PokerCombination.HI_CARD;
            }
        }

        return PokerCombination.HI_CARD;
    }

    public static double getPower(PokerHand hand){
        double power = (detectCombination(hand).ordinal()) * 100d;
        int size = 13;
        int [] pool = new int[size];

        String [] cardStrings = hand.getHand().split(" ");
        List<Card> cards = new ArrayList<>();

        for(String cardStr : cardStrings){
            cards.add(new Card(cardStr));
        }

        Collections.sort(cards, new CardByLabelComparator());

        for(Card card : cards){
            pool[card.getLabel().ordinal()]++;
        }

        for(int i = 0; i < size; i++){
            if(pool[i] == 4){
                power += (40 + i + 1);
            }else if(pool[i] == 3){
                power += (20 + i + 1);
            }else if(pool[i] == 2){
                power += (i + 1);
            }else{
                if(pool[i] == 1)power += Math.pow(10, -(size - i));
            }
        }

        return power;
    }
}
