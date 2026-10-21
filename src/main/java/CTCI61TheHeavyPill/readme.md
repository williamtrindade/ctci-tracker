# 6.1 The Heavy Pill — O Comprimido Pesado

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 6, questão/question **6.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `int findHeavyBottle(Scale scale, int bottleCount)`. A classe `Scale` (pronta) tem
`double weigh(int[] pillsFromEachBottle)`: você informa quantos comprimidos pega de cada frasco (índices 0-based) e
recebe o peso total. Uma segunda chamada lança `IllegalStateException`. Retorne o índice (0-based) do frasco pesado.
