# 6.8 The Egg Drop Problem — O Problema dos Ovos

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 6, questão/question **6.8**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:**

* `int findBreakingFloor(Building building)` — use `building.drop(floor)` (retorna `true` se o ovo quebrou). Você só
  tem **2 ovos**: o terceiro ovo quebrado lança `IllegalStateException`. Os testes exigem no máximo **14** lançamentos
  para qualquer N entre 1 e 100 (o ovo sempre quebra no andar 100).
* `int minDrops(int eggs, int floors)` — generalização: o mínimo de lançamentos no pior caso com `eggs` ovos e `floors`
  andares (com 2 ovos e 100 andares a resposta é 14).
