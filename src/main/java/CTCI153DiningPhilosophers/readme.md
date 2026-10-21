# 15.3 Dining Philosophers — Jantar dos Filósofos

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Chopstick` e `MealLog` já existem. Implemente `Solution.DiningTable`:

* `new DiningTable(int philosophers, MealLog log)` — o filósofo `i` tem o hashi `i` à esquerda e o hashi
  `(i + 1) % n` à direita;
* `void dine(int mealsEach)` — uma thread por filósofo; cada um come `mealsEach` vezes chamando
  `log.eat(i, left, right)` **segurando os dois hashis** (senão o `MealLog` registra violação). Espere todas as threads
  terminarem. Sem deadlock (os testes têm timeout).
