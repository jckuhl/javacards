package com.projectbreakpoint.cards;

enum Suit {
    SPADES(4), DIAMONDS(3), CLUBS(2), HEARTS(1);

    @Override
    public String toString() {
        String suit = super.toString().toLowerCase();
        suit = suit.substring(0, 1).toUpperCase() + suit.substring(1);
        return suit;
    }

    private int value;
    Suit(int value) {
        this.value = value;
    }

    public static Suit getSuit(int value) throws Exception {
        for(Suit suit: Suit.values()) {
            if(suit.value == value) {
                return suit;
            }
        }
        throw new Exception("Invalid numeric value (1-5)");
    }

    public int getValue() {
        return this.value;
    }
}
