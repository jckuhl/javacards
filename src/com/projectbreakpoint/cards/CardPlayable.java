package com.projectbreakpoint.cards;

import java.util.Comparator;

public interface CardPlayable {
    /**
     * Sorts a CardList by suit and by value
     * @param asc set to true to sort ascending, false for descending
     */
    void sort(boolean asc);

    /**
     * Sorts a CardList by a given comparator, giving the user freedom to sort as he sees fit
     * @param comparator
     */
    void sort(Comparator comparator);

    /**
     * Shuffles a CardList
     */
    void shuffle();

    /**
     * Provides a getter for any class implementing CardPlayable
     * @return CardList object
     */
//    CardList getCards();
}
