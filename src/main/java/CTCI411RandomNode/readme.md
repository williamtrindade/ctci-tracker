# 4.11 Random Node — Nó Aleatório

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 4, questão/question **4.11**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.RandomBST`:

* `new RandomBST(Random random)` — use **apenas** esse `Random` (os testes usam semente fixa).
* `void insertInOrder(int value)` (duplicatas vão para a esquerda), `boolean find(int value)`, `int size()`.
* `Integer getRandomNode()` — retorna o **valor** de um nó escolhido uniformemente; `null` se a árvore estiver vazia.
  Tente fazer em O(log n) para árvores balanceadas (O(D), D = profundidade), sem copiar os nós para um array.
