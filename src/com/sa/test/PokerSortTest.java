package com.sa.test;

import com.sa.Combination;
import com.sa.PokerHandComparator;
import com.sa.PokerHand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerSortTest extends Assert {
    @Test
    public void testSortPokerHand(){
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

        assertEquals(pokerHands.get(0).getHand().equals("JH TH KH QH AH"), true);
        assertEquals(pokerHands.get(1).getHand().equals("8H 9H TH JH QH"), true);
        assertEquals(pokerHands.get(2).getHand().equals("AH AC AH AC TS"), true);
        assertEquals(pokerHands.get(3).getHand().equals("8H 8C 8S JH 8D"), true);
        assertEquals(pokerHands.get(4).getHand().equals("8H 8C 8S TH 8D"), true);
        assertEquals(pokerHands.get(5).getHand().equals("8H 8C 8S 3H 8D"), true);
        assertEquals(pokerHands.get(6).getHand().equals("8H 8C 8S 2H 8D"), true);
        assertEquals(pokerHands.get(7).getHand().equals("8H 8C TH TC TS"), true);
        assertEquals(pokerHands.get(8).getHand().equals("8H TH 6H 5H 2H"), true);
        assertEquals(pokerHands.get(9).getHand().equals("8H 9C TH JH QH"), true);
        assertEquals(pokerHands.get(10).getHand().equals("8H 9C TH JH 7C"), true);
        assertEquals(pokerHands.get(11).getHand().equals("8H 8C TH TC QH"), true);
        assertEquals(pokerHands.get(12).getHand().equals("AH AC 2H JH QH"), true);
        assertEquals(pokerHands.get(13).getHand().equals("KH KC TH 3H QH"), true);
        assertEquals(pokerHands.get(14).getHand().equals("KH KC TH 3H JH"), true);
        assertEquals(pokerHands.get(15).getHand().equals("8H 8C 6H 5H 2H"), true);
        assertEquals(pokerHands.get(16).getHand().equals("JH KC TH 3H QH"), true);
        assertEquals(pokerHands.get(17).getHand().equals("8H TC 6H 5D 2C"), true);
        assertEquals(pokerHands.get(18).getHand().equals("3H TC 6H 5D 2C"), true);

        System.out.println(pokerHands);
    }

    @Test
    public void testCombination(){
        assertEquals(Combination.detectCombination(new PokerHand("3H TC 6H 5D 2C")), Combination.PokerCombination.HI_CARD);
        assertEquals(Combination.detectCombination(new PokerHand("8H TC 6H 5D 2C")), Combination.PokerCombination.HI_CARD);
        assertEquals(Combination.detectCombination(new PokerHand("8H TH 6H 5H 2H")), Combination.PokerCombination.FLUSH);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C 6H 5H 2H")), Combination.PokerCombination.PAIR);
        assertEquals(Combination.detectCombination(new PokerHand("8H 9C TH JH QH")), Combination.PokerCombination.STRAIGHT);
        assertEquals(Combination.detectCombination(new PokerHand("8H 9H TH JH QH")), Combination.PokerCombination.STRAIGHT_FLUSH);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C TH TC QH")), Combination.PokerCombination.TWO_PAIR);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C TH TC TS")), Combination.PokerCombination.FULL_HOUSE);
        assertEquals(Combination.detectCombination(new PokerHand("AH AC AH AC TS")), Combination.PokerCombination.FOUR_OF_KIND);
        assertEquals(Combination.detectCombination(new PokerHand("AH AC 2H JH QH")), Combination.PokerCombination.PAIR);
        assertEquals(Combination.detectCombination(new PokerHand("KH KC TH 3H QH")), Combination.PokerCombination.PAIR);
        assertEquals(Combination.detectCombination(new PokerHand("JH TH KH QH AH")), Combination.PokerCombination.STRAIGHT_FLUSH);
        assertEquals(Combination.detectCombination(new PokerHand("JH KC TH 3H QH")), Combination.PokerCombination.HI_CARD);
        assertEquals(Combination.detectCombination(new PokerHand("KH KC TH 3H JH")), Combination.PokerCombination.PAIR);
        assertEquals(Combination.detectCombination(new PokerHand("8H 9C TH JH 7C")), Combination.PokerCombination.STRAIGHT);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C 8S 2H 8D")), Combination.PokerCombination.FOUR_OF_KIND);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C 8S JH 8D")), Combination.PokerCombination.FOUR_OF_KIND);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C 8S TH 8D")), Combination.PokerCombination.FOUR_OF_KIND);
        assertEquals(Combination.detectCombination(new PokerHand("8H 8C 8S 3H 8D")), Combination.PokerCombination.FOUR_OF_KIND);
    }
}
