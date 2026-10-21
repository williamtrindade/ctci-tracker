# 7.1 Deck of Cards — Baralho

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Suit` e `Card` (`faceValue` de 1 a 13: 1 = Ás, 11 = Valete, 12 = Dama, 13 = Rei) já existem. Implemente:

* `Solution.Deck(Random random)` — 52 cartas distintas; `void shuffle()` (use o `random`), `Card dealCard()` (retorna
  `null` quando acabar), `int remainingCards()`.
* `Solution.BlackJackHand` — `void addCard(Card)`, `int score()` (Ás vale 1 ou 11, figuras valem 10; retorne a maior
  pontuação `<= 21`; se todas estourarem, a menor), `boolean busted()`, `boolean is21()`, `boolean isBlackJack()`
  (exatamente duas cartas: um Ás e uma carta de valor 10).
