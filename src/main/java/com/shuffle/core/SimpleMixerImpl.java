package com.shuffle.core;

import com.shuffle.cards.Card;
import com.shuffle.exceptions.EmptyDeckException;

import java.util.List;
import java.util.Random;

/**
 * We get each element from the deck and we generate a new position between 0 and the current position of the element
 */
public class SimpleMixerImpl implements Mixer {

    @Override
    public List<Card> mix(List<Card> card) throws EmptyDeckException {

        if(card == null || card.isEmpty()) {
            throw new EmptyDeckException("The deck is empty");
        }

        Random random = new Random();
        for(int cont = card.size()-1;cont > 0; cont --) {
            int nextPos = random.nextInt(cont);

            Card auxiliarCard = card.get(cont);

            card.set(cont, card.get(nextPos));
            card.set(nextPos, auxiliarCard);
        }
        return card;
    }
}
