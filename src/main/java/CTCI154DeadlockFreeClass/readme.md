# 15.4 Deadlock-Free Class — Classe Livre de Deadlock

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (abordagem do livro):** os processos **declaram antecipadamente** a ordem em que vão pedir os locks.
Implemente `Solution.LockFactory`:

* `new LockFactory(int resourceCount)` — recursos numerados de `0` a `resourceCount - 1`, cada um com um `Lock`;
* `boolean declare(int ownerId, int[] resourcesInOrder)` — registra a ordem; se ela, junto com as já aceitas, puder
  causar deadlock (um **ciclo** no grafo "recurso A é pedido antes de B"), rejeite e retorne `false` sem alterar nada;
* `Lock getLock(int ownerId, int resourceId)` — retorna o lock do recurso se o dono declarou esse recurso, senão
  `null`. O mesmo recurso sempre devolve o mesmo `Lock`.
