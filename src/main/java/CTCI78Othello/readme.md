# 7.8 Othello

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.8**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Regras (como no livro):** tabuleiro 8x8; posição inicial: `(3,3)` e `(4,4)` brancas, `(3,4)` e `(4,3)` pretas. As
capturas acontecem **somente na horizontal e na vertical** (como no enunciado do livro, sem diagonais).

**Exercício:** `Color` já existe. Implemente `Solution.Othello` com `boolean placeColor(int row, int column, Color
color)` (retorna `false` e não altera nada se a jogada for inválida: fora do tabuleiro, casa ocupada ou sem captura),
`Color getColor(int row, int column)` (`null` se vazia), `int getScoreForColor(Color color)` e
`boolean hasValidMove(Color color)`.
