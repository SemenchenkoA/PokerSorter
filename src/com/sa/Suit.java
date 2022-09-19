package com.sa;

public enum Suit {
    S("S"),
    C("C"),
    H("H"),
    D("D");

    private String title;

    Suit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "title='" + title + '\'' +
                '}';
    }
}
