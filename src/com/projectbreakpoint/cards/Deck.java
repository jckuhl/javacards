package com.projectbreakpoint.cards;

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

    private CardList populate() throws Exception {
        if(this.cards.size() == 0) {
            int value = 1;
            int suit = 1;
            while(suit < 5) {
                Card card = new Card(Suit.getSuit(suit), value++);
                this.cards.add(card);
                if(value == 14) {
                    suit++;
                    value = 1;
                }
            }
        }
        return this.cards;
    }

    public Hand drawHand(int size) {
        CardList hand = this.cards.sample(size);
        return new Hand(hand);
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

//    @Override
//    public CardList getCards() {
//        return this.cards;
//    }

    public void setCards(CardList cards) throws Exception {
        if(this.cards.size() == 0) {
            this.cards = cards;
        } else {
            throw new Exception("Cards are already populated!");
        }
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
