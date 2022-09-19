package com.sa;

import java.util.Comparator;

public class CardByLabelComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.getLabel().getPower() > o2.getLabel().getPower() ? -1 : o1.getLabel().getPower() == o2.getLabel().getPower() ? 0 : 1;
    }
}
