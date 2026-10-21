# 13.2 Return from Finally — Return e Finally

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.2**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente cada método **exatamente** como pedido no comentário e descubra o resultado pelos testes:

* `int returnFromTry(List<String> log)` — `return 1` dentro do `try`; o `finally` adiciona `"finally"` ao log;
* `int returnFromCatch(List<String> log)` — o `try` lança exceção, o `catch` faz `return 2`, o `finally` loga;
* `int finallyOverridesReturn()` — `return 1` no `try` e `return 2` no `finally` (má prática!);
* `int finallyCannotChangeReturnedPrimitive()` — `int x = 1; try { return x; } finally { x = 99; }`;
* `List<String> finallyCanMutateReturnedObject()` — retorna uma lista no `try` e o `finally` adiciona `"finally"` nela.
