package com.sa;

public class Card {
    private final String hand;
    private final Label label;
    private final Suit suit;

    public Label getLabel() {
        return label;
    }

    public Suit getSuit() {
        return suit;
    }

    public Card(String hand) {
        this.hand = hand;
        this.label = Label.valueOf("_" + hand.substring(0, 1));
        this.suit = Suit.valueOf(hand.substring(1, 2));
    }

    @Override
    public String toString() {
        return "Card{" +
                "hand='" + hand + '\'' +
                '}';
    }
}
