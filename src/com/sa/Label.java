package com.sa;

public enum Label {
    _2("2"),
    _3("3"),
    _4("4"),
    _5("5"),
    _6("6"),
    _7("7"),
    _8("8"),
    _9("9"),
    _T("T"),
    _J("J"),
    _Q("Q"),
    _K("K"),
    _A("A");

    private String title;

    public int getPower() {
        return power = this.ordinal();
    }

    private int power;

    Label(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Label{" +
                "title='" + title + '\'' +
                '}';
    }
}
