# 13.3 Final, etc.

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:**

* `final`: implemente `Solution.ImmutablePoint` — classe **final**, campos `x` e `y` **final**, `getX()`, `getY()` e
  `ImmutablePoint withX(int newX)` (retorna um novo ponto). O stub não é final — corrija (os testes usam reflexão).
* `finally`: implemente `String readAndClose(Resource resource)` — chama `open()`, depois `read()`, e garante que
  `close()` seja chamado **sempre**, mesmo se `read()` lançar exceção (a exceção deve ser propagada).
* `finalize`: está *deprecated*; leia a resposta para saber por quê e o que usar no lugar.
