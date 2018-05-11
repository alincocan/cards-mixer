package com.shuffle.core;

import com.shuffle.cards.Card;
import com.shuffle.exceptions.EmptyDeckException;
import com.shuffle.exceptions.OutOfDeckException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * We choose a completely random number of cards to mix from our deck. For each element, we choose a random card and for that random card we
 * choose a random next position. By moving the selected cards to a new list we avoid to select the same card multiple times.
 */
public class MixerImpl implements Mixer {

    @Override
    public List<Card> mix(final List<Card> cards) throws EmptyDeckException, OutOfDeckException {

        if(cards == null || cards.isEmpty()) {
            throw new EmptyDeckException("The deck is empty");
        }

        int currentDeckSize = cards.size();

        Random random = new Random();
        List<Card> mixedCards = new ArrayList<>(currentDeckSize);
        cards.forEach(card -> {mixedCards.add(null);});

        int numberOfCardsToMix = random.nextInt(cards.size());
        System.out.println(numberOfCardsToMix + " cards have been selected to be mixed");

        if(numberOfCardsToMix > currentDeckSize) {
            throw new OutOfDeckException("The number of cards to be mixed is bigger then the number of cards from the deck");
        }

        while(numberOfCardsToMix > 0) {
            int selectedCard = random.nextInt(cards.size());
            int nextPos = random.nextInt(currentDeckSize);
            if(nextPos <0 && nextPos > 51) {
                throw new OutOfDeckException("position " + nextPos + " not found");
            }
            System.out.println(cards.get(selectedCard) + " from position " + selectedCard  + " to position " + nextPos);

            mixedCards.add(nextPos,cards.get(selectedCard));
            cards.remove(cards.get(selectedCard));
            numberOfCardsToMix--;
        }

        int firstNullPosition = 0;
        for(int i = 0 ; i < cards.size();i++) {
            for(int j = firstNullPosition; i < mixedCards.size(); j++) {
                if(mixedCards.get(j) == null) {
                    mixedCards.set(j, cards.get(i));
                    firstNullPosition = j+1;
                    break;
                }
            }
        }

        for(int i = firstNullPosition;i<mixedCards.size();i++) {
            if(mixedCards.get(i) == null) {
                mixedCards.remove(mixedCards.get(i));
                i--;
            }
        }
        return mixedCards;
    }
}
