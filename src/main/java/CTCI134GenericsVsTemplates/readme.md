# 13.4 Generics vs. Templates

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (consequências do *type erasure*):** dentro de `Solution`:

* `Box<T>` com `T get()` e um contador estático `static int instanceCount()` de quantas `Box` foram criadas — em Java o
  campo estático é **compartilhado** por `Box<String>` e `Box<Integer>` (em C++ cada instanciação do template teria o
  seu);
* `static boolean sameRuntimeClass(Object a, Object b)` — `true` se os objetos têm exatamente a mesma classe em tempo de
  execução (`new ArrayList<String>()` vs `new ArrayList<Integer>()`?);
* `static <T extends Comparable<T>> T max(List<T> list)` — generics com limite (bounded type); lista vazia →
  `NoSuchElementException`.
