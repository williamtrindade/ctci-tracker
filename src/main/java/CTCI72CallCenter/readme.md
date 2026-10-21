# 7.2 Call Center

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.2**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Rank`, `Call` e `Employee` já existem. Implemente `Solution.CallHandler`:

* `new CallHandler(int respondents, int managers, int directors)` — cria os funcionários.
* `Employee dispatchCall(Call call)` — atribui ao primeiro funcionário livre com nível `>= call.getRank()`, sempre
  procurando do nível mais baixo para o mais alto (e, dentro do nível, na ordem de criação). Se ninguém puder atender,
  enfileira (FIFO) e retorna `null`.
* `void callCompleted(Employee e)` — libera o funcionário e ele atende a ligação mais antiga da fila que conseguir.
* `void escalate(Employee e)` — o funcionário não consegue resolver: a ligação sobe um nível (`call.incrementRank()`),
  o funcionário é liberado (e pega uma ligação da fila, se houver) e a ligação é redistribuída com `dispatchCall`.
* `int queuedCalls()`.
