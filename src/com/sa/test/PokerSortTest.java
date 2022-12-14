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

        assertTrue(pokerHands.get(0).getHand().equals("JH TH KH QH AH"));
        assertTrue(pokerHands.get(1).getHand().equals("8H 9H TH JH QH"));
        assertTrue(pokerHands.get(2).getHand().equals("AH AC AH AC TS"));
        assertTrue(pokerHands.get(3).getHand().equals("8H 8C 8S JH 8D"));
        assertTrue(pokerHands.get(4).getHand().equals("8H 8C 8S TH 8D"));
        assertTrue(pokerHands.get(5).getHand().equals("8H 8C 8S 3H 8D"));
        assertTrue(pokerHands.get(6).getHand().equals("8H 8C 8S 2H 8D"));
        assertTrue(pokerHands.get(7).getHand().equals("8H 8C TH TC TS"));
        assertTrue(pokerHands.get(8).getHand().equals("8H TH 6H 5H 2H"));
        assertTrue(pokerHands.get(9).getHand().equals("8H 9C TH JH QH"));
        assertTrue(pokerHands.get(10).getHand().equals("8H 9C TH JH 7C"));
        assertTrue(pokerHands.get(11).getHand().equals("8H 8C TH TC QH"));
        assertTrue(pokerHands.get(12).getHand().equals("AH AC 2H JH QH"));
        assertTrue(pokerHands.get(13).getHand().equals("KH KC TH 3H QH"));
        assertTrue(pokerHands.get(14).getHand().equals("KH KC TH 3H JH"));
        assertTrue(pokerHands.get(15).getHand().equals("8H 8C 6H 5H 2H"));
        assertTrue(pokerHands.get(16).getHand().equals("JH KC TH 3H QH"));
        assertTrue(pokerHands.get(17).getHand().equals("8H TC 6H 5D 2C"));
        assertTrue(pokerHands.get(18).getHand().equals("3H TC 6H 5D 2C"));

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

    @Test
    public void testCompareCombination(){
        double powerHand1 = Combination.getPower(new PokerHand("3H TC 6H 5D 2C"));
        double powerHand2 = Combination.getPower(new PokerHand("KH KC TH 3H QH"));

        assertTrue(powerHand1 < powerHand2);

        System.out.println("power hand1 = %.13f, power hand2 = %.13f".formatted(powerHand1, powerHand2));

        powerHand1 = Combination.getPower(new PokerHand("8H 8C 8S 2H 8D"));
        powerHand2 = Combination.getPower(new PokerHand("JH TH KH QH AH"));

        assertTrue(powerHand1 < powerHand2);

        System.out.println("power hand1 = %.13f, power hand2 = %.13f".formatted(powerHand1, powerHand2));

    }
}
