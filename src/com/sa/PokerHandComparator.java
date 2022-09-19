package com.sa;

import java.util.*;

public class PokerHandComparator implements Comparator<PokerHand> {

    @Override
    public int compare(PokerHand hand1, PokerHand hand2) {
        double power1 = Combination.getPower(hand1);
        double power2 = Combination.getPower(hand2);

        //System.out.println("power1 = %.13f".formatted(power1));
        //System.out.println("power2 = %.13f".formatted(power2));

        return (power1 > power2 ? -1 : (power1 == power2 ? 0 : 1));
    }
}
