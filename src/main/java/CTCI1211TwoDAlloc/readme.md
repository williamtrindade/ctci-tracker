# 12.11 2D Alloc — Alocação 2D

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.11**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (simulando a solução de um único malloc):** implemente `Solution.Matrix2D`:

* `static Matrix2D my2DAlloc(int rows, int cols)` — usa **um único** `int[]` de tamanho `rows + rows * cols`: as
  primeiras `rows` posições são os "ponteiros" de cada linha (o índice onde a linha começa) e o resto são os dados;
* `int get(int i, int j)` / `void set(int i, int j, int value)` — acessam `backing[backing[i] + j]` (como `arr[i][j]`);
* `int[] backingArray()`.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_11_2d_alloc.cpp`](../../../../cpp/12_11_2d_alloc.cpp)
