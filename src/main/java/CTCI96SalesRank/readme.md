# 9.6 Sales Rank — Ranking de Vendas

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.SalesRank` (ranking pelas vendas dos **últimos N dias**, como o livro sugere):

* `void registerProduct(String productId, Set<String> categories)`;
* `void recordSale(String productId, LocalDate date, int quantity)`;
* `List<String> topProducts(String category, LocalDate today, int lastDays, int k)` — `category == null` significa
  geral; considera vendas de `today - lastDays + 1` até `today`; ordena por unidades vendidas (desc) e, em empate, pelo
  id (asc); produtos sem vendas na janela não aparecem;
* `int rankOf(String productId, String category, LocalDate today, int lastDays)` — posição (1-based) nesse ranking, ou
  `-1` se não aparecer.
