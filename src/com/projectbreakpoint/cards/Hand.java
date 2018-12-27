package com.projectbreakpoint.cards;

import java.util.Comparator;
import java.util.Iterator;

public class Hand implements CardPlayable, Iterable<Card> {

    private int size;
    private CardList cards = new CardList();

    public Hand() {
        this.size = 5;
        this.cards = cards;
    }

    public Hand(int size) {
        this.size = size;
    }

    public Hand(CardList cards) {
        this.cards = cards;
    }

    @Override
    public void sort(boolean asc) {
        this.cards.sort(asc);
    }

    @Override
    public void sort(Comparator comparator) {
        this.cards.sort(comparator);
    }

    @Override
    public void shuffle() {
        this.cards.shuffle();
    }

    @Override
    public String toString() {
        String cards = "";
        for(Object card: this.cards) {
            cards += card.toString();
        }
        return cards;
    }


    @Override
    public Iterator<Card> iterator() {
        return this.cards.iterator();
    }
}
