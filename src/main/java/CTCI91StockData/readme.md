# 9.1 Stock Data — Dados de Ações

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (o núcleo do serviço, em memória):** `StockRecord` já existe. Implemente `Solution.StockDataService`:
`void addRecord(StockRecord r)` (substitui o registro do mesmo símbolo/data), `StockRecord getRecord(String symbol,
LocalDate date)` (`null` se não houver), `List<StockRecord> getRecords(String symbol, LocalDate from, LocalDate to)`
(intervalo inclusivo, ordenado por data), `List<String> getSymbols()` (ordem alfabética) e
`String toXml(StockRecord r)` no formato:
`<stock symbol="GOOG" date="2026-10-16"><open>1.0</open><close>2.0</close><high>3.0</high><low>0.5</low></stock>`.
