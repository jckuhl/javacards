package com.projectbreakpoint.cards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Deck implements CardPlayable, Iterable<Card> {

    private CardList cards = new CardList();
    private int size;
    private boolean acesHigh;
    private boolean jokers;

    /**
     * Default No-Args constructor, assumes typical set up for a deck
     */
    public Deck() throws Exception {
        this.size = 52;
        this.acesHigh = true;
        this.jokers = false;
        this.cards = this.populate();
    }

    /**
     * Custom size deck, passes on card population to child classes or consumer
     * @param size
     */
    public Deck(int size, boolean acesHigh, boolean jokers) {
        this.size = size;
        this.acesHigh = acesHigh;
        this.jokers = jokers;
    }

    /**
     * Populates a cardlist with a default deck of cards, no jokers, 52 cards.
     * @return returns a populated Cardlist
     * @throws Exception
     */
    private CardList populate() throws Exception {
        if(this.cards.size() == 0) {
            int value = 1;
            int suit = 4;
            while(suit > 0) {
                Card card = new Card(Suit.getSuit(suit), value++);
                this.cards.add(card);
                if(value == 14) {
                    suit--;
                    value = 1;
                }
            }
        }
        return this.cards;
    }

    public Hand drawHand(int size) throws Exception {
        if(size > this.cards.size()) {
            throw new Exception("A hand may not exceed the number of cards in a deck");
        }
        CardList hand = this.cards.sample(size);
        for(Card card: hand) {
            this.cards.remove(card);
        }
        return new Hand(hand);
    }

    public Card drawCard(Card card) {
        this.cards.remove(card);
        return card;
    }

    public Card drawCard() {
        int index = (int) (Math.random() * this.cards.size());
        return this.cards.remove(index);
    }

    public Card drawCard(int index) {
        return this.cards.remove(index);
    }

    public void addCard(Card card) throws Exception {
        if(this.cards.size() < this.size) {
            this.cards.add(card);
        } else {
            throw new Exception("The deck can't hold more cards than it's max size of " + this.size);
        }
    }

    public void addCard(CardList cards) throws Exception {
        if(this.cards.size() + cards.size() < this.size) {
            this.cards.addAll(cards);
        } else {
            throw new Exception("The deck can't hold more cards than it's max size of " + this.size);
        }
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

    public void setCards(CardList cards) throws Exception {
        if(this.cards.size() == 0) {
            this.cards = cards;
        } else {
            throw new Exception("Cards are already populated!");
        }
    }

    public void setCards(ArrayList cards) throws Exception {
        if(this.cards.size() == 0) {
            this.cards = new CardList(cards);
        } else {
            throw new Exception("Cards are already populated!");
        }
    }

    public int getCurrentSize() {
        return this.cards.size();
    }

    @Override
    public String toString() {
        String deck = "";
        if(this.cards.size() == 0) {
            return "Empty deck";
        }
        for(Object card: this.cards) {
            deck += card.toString();
        }
        return deck;
    }


    @Override
    public Iterator<Card> iterator() {
        return this.cards.iterator();
    }
}
