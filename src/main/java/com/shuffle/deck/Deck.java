package com.shuffle.deck;

import com.shuffle.cards.Card;
import com.shuffle.core.Mixer;
import com.shuffle.exceptions.EmptyDeckException;
import com.shuffle.exceptions.OutOfDeckException;

import java.util.List;

public class Deck {

    private List<Card> cards;
    private final Mixer mixer;
    public static final int DECK_SIZE  = 52;

    public Deck(final DeckBuilder deckBuilder,final Mixer mixer) {

        this.cards = deckBuilder.build();
        this.mixer = mixer;
    }

    public void shuffle()throws EmptyDeckException, OutOfDeckException {
            this.cards = this.mixer.mix(cards);
    }

    public void print() {
        cards.forEach(card -> {
            System.out.print(card + " ");
        });
        System.out.println();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
