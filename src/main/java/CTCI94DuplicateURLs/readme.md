# 9.4 Duplicate URLs — URLs Duplicadas

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (simulação da solução de disco do livro):** implemente em `Solution`:

* `int partitionOf(String url, int partitions)` — em qual "arquivo" (0 a `partitions - 1`) a URL vai, por hash (URLs
  iguais sempre caem na mesma partição).
* `Set<String> findDuplicates(List<String> urls, int partitions)` — 1ª passada: distribua as URLs nas partições;
  2ª passada: em cada partição, use um `HashSet` para achar as repetidas. Retorne as URLs que aparecem mais de uma vez.
