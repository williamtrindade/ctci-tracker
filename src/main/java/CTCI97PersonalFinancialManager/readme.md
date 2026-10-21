# 9.7 Personal Financial Manager — Gerenciador Financeiro Pessoal

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (o núcleo de categorização e orçamento):** implemente `Solution.FinanceManager`:

* `void addCategoryRule(String merchantKeyword, String category)` — a **primeira** regra cujo termo aparece no nome do
  estabelecimento (sem diferenciar maiúsculas) define a categoria; sem regra → `"Other"`;
* `void addTransaction(String user, LocalDate date, String merchant, double amount)`;
* `void setBudget(String user, String category, double monthlyLimit)`;
* `Map<String, Double> spendingByCategory(String user, YearMonth month)`;
* `List<String> overBudgetCategories(String user, YearMonth month)` — categorias com gasto **maior** que o orçamento,
  em ordem alfabética.
