# 7.9 Circular Array — Array Circular

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.9**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.CircularArray<T> implements Iterable<T>`:

* `new CircularArray<>(int size)`, `T get(int i)`, `void set(int i, T item)`, `int size()`;
* `void rotate(int shiftRight)` — como no livro, o elemento que estava no índice `shiftRight` passa a ser o índice 0
  (ex.: `[a, b, c].rotate(1)` → `[b, c, a]`). Aceite valores negativos e maiores que o tamanho. Deve ser **O(1)**.
* Índices fora de `[0, size)` lançam `IndexOutOfBoundsException`. O iterador percorre a partir do índice 0 lógico.
