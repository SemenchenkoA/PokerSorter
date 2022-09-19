package com.sa;

public class PokerHand {
    private String hand;

    public PokerHand(String hand) {
        this.hand = hand;
    }

    public String getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "hand='" + hand + '\'' +
                "}\n";
    }
}
