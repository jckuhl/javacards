package com.projectbreakpoint.cards;

import java.util.*;

/**
 * A composition of ArrayList for a list of cards
 */
final class CardList implements Iterable<Card> {

    private ArrayList<Card> list;

    /**
     * Creates a cardlist object from an ArrayList of cards
     * @param cards
     * @throws Exception
     */
    public CardList(ArrayList<Card> cards) throws Exception {
        if(cards.get(0).getClass().toString().equalsIgnoreCase("Card")) {
            this.list = cards;
        } else {
            throw new Exception("Collection must be of type Collection<Card>");
        }
    }

    /**
     * Default no-args
     * Creates an empty CardList
     */
    public CardList() {
        this.list = new ArrayList<Card>();
    }

    /**
     * Returns the size of the CardList
     * @return Integer
     */
    public int size() {
        return this.list.size();
    }

    public boolean add(Card card) {
        return this.list.add(card);

    }

    public boolean remove(Card card) {
        return this.list.remove(card);
    }

    public Card remove(int index) {
        return this.list.remove(index);
    }

    public Card get(int index) {
        return this.list.get(index);
    }

    public void set(int index, Card card) {
        this.list.set(index, card);
    }

    public boolean addAll(CardList cards) {
        return this.list.addAll(cards.list);
    }

    public boolean addAll(int index, CardList cards) {
        return this.list.addAll(index, cards.list);
    }

    public CardList sample(int size) {
        CardList cards = new CardList();
        while(cards.size() < size) {
            int index = (int) (Math.random() * this.list.size());
            cards.add(this.get(index));
        }
        return cards;
    }

    /**
     * Shuffles the list IN PLACE
     */
    public void shuffle() {
        int counter = this.list.size();
        while(counter > 0) {
            int index = (int) (Math.random() * counter--);
            Card temp = this.list.get(counter);
            this.list.set(counter, this.list.get(index));
            this.list.set(index, temp);
        }
    }

    public void sort(boolean asc) {

        if(asc) {
            this.list.sort((Card c1, Card c2) -> c2.getValue() - c1.getValue());
        } else {
            this.list.sort((Card c1, Card c2) -> c1.getValue() - c2.getValue());
        }
    }

    public void sort(Comparator<Card> comparator) {
        Collections.sort(this.list, comparator);
    }

    @Override
    public String toString() {
        String cards = "";
        for(Card card: this.list) {
            cards += card.toString();
        }
        return cards;
    }

    @Override
    public Iterator<Card> iterator() {
        return this.list.iterator();
    }
}
