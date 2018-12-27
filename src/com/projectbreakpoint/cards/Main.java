package com.projectbreakpoint.cards;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        deck.sort(true);
        System.out.println(deck);
        deck.sort(false);
        System.out.println(deck);

        Hand hand = deck.drawHand(5);
        System.out.println(hand);
        hand.shuffle();
        System.out.println(hand);
        hand.sort(false);
        System.out.println(hand);
        hand.shuffle();
        System.out.println(hand);
        hand.sort(true);

//        ArrayList<Integer> ints = new ArrayList();
//        ints.add(1);
//        ints.add(2);
//        CardList cards = new CardList(ints);
//
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(new Card(Suit.DIAMONDS,2));
//        cards.add(new Card(Suit.SPADES, 3));
//
//        System.out.println(cards);
    }
}
