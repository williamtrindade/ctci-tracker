# 10.7 Missing Int — Inteiro Faltante

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 10, questão/question **10.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (escala reduzida):** os valores estão em `[0, range)`.

* `int findOpenNumber(int[] numbers, int range)` — use um **vetor de bits** de `range` bits (1 bit por número).
* `int findOpenNumberTwoPass(int[] numbers, int range, int blockSize)` — follow up: 1ª passada conta quantos números
  caem em cada bloco de `blockSize` valores; ache um bloco "incompleto"; 2ª passada usa um vetor de bits só desse bloco.
  Assuma valores distintos.

Retorne qualquer número de `[0, range)` ausente (os testes garantem que existe).
