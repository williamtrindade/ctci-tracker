# 8.2 Robot in a Grid — Robô na Grade

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 8, questão/question **8.2**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Assinatura:** `List<Point> getPath(boolean[][] maze)` — `maze[r][c] == true` indica célula livre. Retorne o caminho
completo (de `(0,0)` até `(r-1,c-1)`, inclusive) ou `null` se não existir. Os testes têm grades grandes sem saída:
memoize as células que já falharam.
