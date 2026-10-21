# 6.3 Dominos — Dominós

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 6, questão/question **6.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (generalizado):** implemente `boolean canBeTiled(boolean[][] board)`, onde `board[r][c] == true` indica
que o quadrado existe. Retorne se é possível cobrir **todos** os quadrados existentes com dominós (cada dominó cobre
dois quadrados adjacentes na horizontal ou vertical, sem sobreposição). Dica: o argumento de cores do livro resolve o
caso do tabuleiro mutilado, mas não basta para qualquer formato — pense em emparelhamento bipartido.
