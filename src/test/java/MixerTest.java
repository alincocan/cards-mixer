import com.shuffle.cards.*;
import com.shuffle.core.MixerImpl;
import com.shuffle.deck.Deck;
import com.shuffle.deck.DeckBuilderImpl;
import com.shuffle.deck.EmptyDeckBuilder;
import com.shuffle.exceptions.EmptyDeckException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class MixerTest {

    Deck deck;

    @Before
    public void initData() {
        deck = new Deck(new DeckBuilderImpl(), new MixerImpl());
        Assert.assertNotNull(deck);
        Assert.assertNotNull(deck.getCards());
        Assert.assertFalse(deck.getCards().isEmpty());
    };

    @Test
    public void testLength() {
        Assert.assertNotNull(deck);
        try {

            deck.shuffle();
            Assert.assertEquals(deck.getCards().size(), Deck.DECK_SIZE);

        }
        catch (Exception ex) {
            Assert.fail();
        }}

    @Test
    public void testForDuplicates() {
        HashMap<Card, Integer> frequencyArray= new HashMap<>();
        deck.getCards().forEach(card -> {
            if(frequencyArray.get(card) != null) {
                Assert.fail("The card " + card.toString() + "is duplicated") ;
            }
            frequencyArray.put(card, 1);
        });
    }

    @Test(expected = EmptyDeckException.class)
    public void testEmptyDeck() {
        deck = new Deck(new EmptyDeckBuilder(), new MixerImpl());
        deck.shuffle();
    }
}
