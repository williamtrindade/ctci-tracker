package CTCI71DeckOfCards;

/** Carta: faceValue de 1 (Ás) a 13 (Rei). */
public record Card(int faceValue, Suit suit) {
    public Card {
        if (faceValue < 1 || faceValue > 13) {
            throw new IllegalArgumentException("faceValue deve estar entre 1 e 13");
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11;
    }
}
