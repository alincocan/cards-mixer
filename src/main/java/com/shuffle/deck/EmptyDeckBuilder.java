package com.shuffle.deck;

import com.shuffle.cards.Card;
import com.shuffle.deck.DeckBuilder;

import java.util.Collections;
import java.util.List;

public class EmptyDeckBuilder implements DeckBuilder {

    @Override
    public List<Card> build() {
        return Collections.emptyList();
    }
}
