# 9.5 Cache

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.QueryCache` (o cache LRU de uma "fatia" do cache distribuído):

* `new QueryCache(int maxSize, Function<String, String> processSearch)`;
* `String getResults(String query)` — retorna do cache ou chama `processSearch` (uma única vez por query enquanto ela
  estiver em cache); ao exceder `maxSize`, remove a query **usada há mais tempo**;
* `void invalidate(String query)` (os dados mudaram), `int size()`, `boolean contains(String query)`;
* `static int machineFor(String query, int machines)` — qual máquina guarda a query (hash), sempre a mesma para a
  mesma query.
