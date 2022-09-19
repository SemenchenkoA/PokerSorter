package com.sa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<PokerHand> pokerHands = new ArrayList<>();

        pokerHands.add(new PokerHand("3H TC 6H 5D 2C"));
        pokerHands.add(new PokerHand("8H TC 6H 5D 2C"));
        pokerHands.add(new PokerHand("8H TH 6H 5H 2H"));
        pokerHands.add(new PokerHand("8H 8C 6H 5H 2H"));
        pokerHands.add(new PokerHand("8H 9C TH JH QH"));
        pokerHands.add(new PokerHand("8H 9H TH JH QH"));
        pokerHands.add(new PokerHand("8H 8C TH TC QH"));
        pokerHands.add(new PokerHand("8H 8C TH TC TS"));
        pokerHands.add(new PokerHand("AH AC AH AC TS"));
        pokerHands.add(new PokerHand("AH AC 2H JH QH"));
        pokerHands.add(new PokerHand("KH KC TH 3H QH"));
        pokerHands.add(new PokerHand("JH TH KH QH AH"));
        pokerHands.add(new PokerHand("JH KC TH 3H QH"));
        pokerHands.add(new PokerHand("KH KC TH 3H JH"));
        pokerHands.add(new PokerHand("8H 9C TH JH 7C"));
        pokerHands.add(new PokerHand("8H 8C 8S 2H 8D"));
        pokerHands.add(new PokerHand("8H 8C 8S JH 8D"));
        pokerHands.add(new PokerHand("8H 8C 8S TH 8D"));
        pokerHands.add(new PokerHand("8H 8C 8S 3H 8D"));

        Collections.sort(pokerHands, new PokerHandComparator());

        System.out.println("===================================");

        System.out.println(pokerHands);
    }
}
