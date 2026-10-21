# 3.1 Three in One — Três em Um

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 3, questão/question **3.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.FixedMultiStack` (divisão fixa do array, como na primeira solução do livro):

* `new FixedMultiStack(int stackCapacity)` — 3 pilhas, cada uma com `stackCapacity` posições, todas em **um único
  `int[]`** de tamanho `3 * stackCapacity`.
* `void push(int stackNum, int value)` — lança `FullStackException` se a pilha estiver cheia.
* `int pop(int stackNum)` / `int peek(int stackNum)` — lançam `java.util.EmptyStackException` se vazia.
* `boolean isEmpty(int stackNum)`, `boolean isFull(int stackNum)`. `stackNum` vai de 0 a 2.
