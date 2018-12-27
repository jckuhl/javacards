package com.projectbreakpoint.cards;

public enum Suit {
    SPADES(1), DIAMONDS(2), CLUBS(3), HEARTS(4);

    @Override
    public String toString() {
        String suit = super.toString().toLowerCase();
        suit = suit.substring(0, 1).toUpperCase() + suit.substring(1);
        return suit;
    }

    private int num;
    Suit(int num) {
        this.num = num;
    }

    public static Suit getSuit(int num) throws Exception {
        for(Suit suit: Suit.values()) {
            if(suit.num == num) {
                return suit;
            }
        }
        throw new Exception("Invalid numeric value (1-5)");
    }
}
