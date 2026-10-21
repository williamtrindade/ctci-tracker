# 7.10 Minesweeper — Campo Minado

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.10**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `GameState` já existe. Implemente `Solution.MinesweeperGame`:

* `new MinesweeperGame(int rows, int cols, int[][] bombs)` — `bombs` é a lista de posições `{linha, coluna}`.
* `GameState play(int row, int col)` — revela a célula (ignorado se tiver bandeira, já revelada ou jogo encerrado);
  retorna o estado (`RUNNING`, `WON`, `LOST`).
* `void toggleFlag(int row, int col)` — marca/desmarca bandeira em célula não revelada.
* `char[][] display()` — `'?'` oculta, `'F'` bandeira, `'*'` bomba revelada, `' '` vazia, `'1'`–`'8'` números.
* `static int[][] randomBombs(int rows, int cols, int count, Random random)` — sorteia `count` posições distintas.
