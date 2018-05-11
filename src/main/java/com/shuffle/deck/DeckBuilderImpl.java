package com.shuffle.deck;

import com.shuffle.cards.Card;
import com.shuffle.cards.Face;
import com.shuffle.cards.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckBuilderImpl implements DeckBuilder {

    @Override
    public List<Card> build() {
        List<Card> cards = new ArrayList<>(Deck.DECK_SIZE);

        Arrays.stream(Type.values()).forEach(type -> {
            Arrays.stream(Face.values()).forEach(face -> {
                cards.add(new Card(type,face));
            });
        });
        return cards;
    }
}
