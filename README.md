# Java Cards

A basic framework for card games, provides the underlying implementation for any game involving a deck of playing cards.

# API

## Card

Models a single playing card, with three properties:

- `private Suit suit`: A member of the Suit enum -
   - HEARTS
   - SPADES
   - DIAMONDS
   - CLUBS
   - JOKER
- `private int value`: An `int` value between 1 and 14.  1 for Aces up to 13 for Kings.  14 for Jokers if enabled.
- `private Face face`: Computed by the constructor depending on value, based on `Face` enum

All three properties are private, but can be retrieved with getters.

#### Constructors

##### `public Card(Suit suit, int value)`

Constructs a basic playing card with a specific suit and value.  Set `suit` to `Suit.JOKER` and `value` to `14` to create a Joker card.

#### Methods

##### Getters
- `public Face getFace()`
- `public Suit getSuit()`
- `public int getValue()`

Retrieves the appropriate fields from the class

##### `toString()`

Returns a string representation of the object in the form of `|<Face> of <Suit>|`

## Deck

Models a deck of cards.  Default is 52 cards, but constructors are implemented to be more loosely defined for games with multiple decks (alternatively you could use two deck objects) or games like Pinochle that only have face cards.

The deck's properties are as follows:
- `private CardList cards`: A `CardList` of `Card` objects
- `private int size`: An `Integer` indicating the number of cards to the deck
- `private boolean acesHigh`: A `boolean` indicating if aces are high
- `private boolean jokers`: A `boolean` indicating if the deck has jokers

#### Constructors

##### `public Deck()`

Default no-args constructor, creates and populates a deck of 52 playing cards with no jokers

##### `public Deck(int size, boolean acesHigh, boolean jokers)`

Creates a deck of cards for a given size.  `acesHigh` indicates Aces will have be greater than kings.  `jokers` indicate the deck has jokers.

This constructor does not populate the deck, the deck must be populated through other means such as through `deck.setCards()`

#### Methods

##### Getters
None

##### `public Hand drawHand(int size) throws Exception`

Creates a hand of `size` cards.  Size cannot be greater than the size of the deck or an exception will be thrown.  Cards added to the hand are removed from the deck.  Cards drawn are picked random via the `sample()` method on `Cardlist`

##### `public Card drawCard(Card card)`

Draws and removes a specific card from the deck

##### `public Card drawCard()`

Draws and removes a random card from the deck

##### `public Card drawCard(int index)`

Draws and removes a card from the deck at a specific index

##### `public void addCard(Card card) throws Exception`

Adds a card to the deck, if the deck has room.  Throws an exception if the deck is full

##### `public void sort(boolean asc)`

Sorts the deck starting with the largest heart to the smallest club, or vice versa, depending on whether `asc` (_ascending_) is set to `true` or not.  Basic default sort, as if it was a deck of cards that have never been played before

##### `public void sort(Comparator comparator)`

Sorts the deck with a user-defined algorithm.

##### `public void shuffle()`

Performs a random shuffle on the deck

##### `public void setCards(CardList cards) throws Exception`

Adds a CardList to the deck, if the deck is empty.  If the deck is not empty, an exception is thrown.

##### `public void setCards(ArrayList cards) throws Exception`

Adds an ArrayList to the deck (it gets converted to a CardList), if the deck is empty.  If the deck is not empty, an exception is thrown.

##### `public int getCurrentSize()`

Returns the current number of cards in the deck

## Hand

Models a player hand.

#### Constructors

##### `public Hand()`

The No-Arg constructor creates a default 5 card hand

##### `public Hand(int size)`

Creates a hand of a given `size`

##### `public Hand(CardList cards)`

Creates a hand from a given CardList

#### Methods

##### `public void returnToDeck(Deck deck, Card card) throws Exception`

Returns a card to the deck, throws an exception if the deck is full

##### `public void returnToDeck(Deck deck, CardList cards) throws Exception`

Returns a CardList to the deck, throws an exception if the deck is full

##### `public void sort(boolean asc)`

Sorts the hand starting with the largest heart to the smallest club, or vice versa, depending on whether `asc` (_ascending_) is set to `true` or not.  Basic default sort

##### `public void sort(Comparator comparator)`

Sorts the hand with a user-defined algorithm.

##### `public void shuffle()`

Performs a random shuffle on the hand