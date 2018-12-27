package com.projectbreakpoint.cards;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private Suit suit;
    private int value;
    private Face face;

    public Card(Suit suit, int value) throws Exception {
        this.suit = suit;
        this.value = value;
        this.face = Face.getFace(this.value);
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return this.value;
    }

    public Face getFace() {
        return this.face;
    }

    @Override
    public String toString() {
        return String.format("| %d  of %s |", this.value, this.suit.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, value);
    }

    @Override
    public int compareTo(Card o) {
        return this.value - o.value;
    }
}
