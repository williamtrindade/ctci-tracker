package CTCI71DeckOfCards;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private static Solution.BlackJackHand hand(int... faceValues) {
        Solution.BlackJackHand hand = new Solution.BlackJackHand();
        for (int v : faceValues) {
            hand.addCard(new Card(v, Suit.SPADE));
        }
        return hand;
    }

    @Test
    void deckHas52DistinctCards() {
        Solution.Deck deck = new Solution.Deck(new Random(1));
        deck.shuffle();
        assertEquals(52, deck.remainingCards());
        Set<Card> seen = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            seen.add(deck.dealCard());
            assertEquals(51 - i, deck.remainingCards());
        }
        assertEquals(52, seen.size());
        assertNull(deck.dealCard());
    }

    @Test
    void shuffleChangesTheOrder() {
        Solution.Deck d1 = new Solution.Deck(new Random(1));
        Solution.Deck d2 = new Solution.Deck(new Random(2));
        d1.shuffle();
        d2.shuffle();
        List<Card> o1 = new ArrayList<>();
        List<Card> o2 = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            o1.add(d1.dealCard());
            o2.add(d2.dealCard());
        }
        assertNotEquals(o1, o2, "Sementes diferentes devem gerar ordens diferentes");
        assertEquals(new HashSet<>(o1), new HashSet<>(o2));
    }

    @Test
    void blackJackScores() {
        assertEquals(21, hand(1, 13).score());
        assertTrue(hand(1, 13).isBlackJack());
        assertTrue(hand(10, 1).isBlackJack());
        assertFalse(hand(5, 6, 10).isBlackJack());
        assertTrue(hand(5, 6, 10).is21());
        assertEquals(12, hand(1, 1).score());      // 11 + 1
        assertEquals(21, hand(1, 1, 9).score());   // 11 + 1 + 9
        assertEquals(13, hand(1, 1, 1).score());   // 11 + 1 + 1
        assertEquals(20, hand(12, 13).score());    // figuras valem 10
        assertEquals(17, hand(1, 6).score());
        assertEquals(17, hand(1, 6, 10).score());  // o Ás passa a valer 1
    }

    @Test
    void busted() {
        Solution.BlackJackHand h = hand(10, 12, 5);
        assertEquals(25, h.score());
        assertTrue(h.busted());
        assertFalse(hand(10, 1).busted());
    }
}
