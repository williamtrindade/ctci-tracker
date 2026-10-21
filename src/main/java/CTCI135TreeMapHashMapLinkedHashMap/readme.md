# 13.5 TreeMap, HashMap, LinkedHashMap

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente as fábricas em `Solution`, escolhendo a classe certa para cada necessidade:

* `static <K, V> Map<K, V> sortedByKey()` — iteração em ordem das chaves;
* `static <K, V> Map<K, V> insertionOrdered()` — iteração na ordem de inserção;
* `static <K, V> Map<K, V> fastest()` — só precisa de busca rápida, sem ordem;
* `static <K, V> Map<K, V> lruCache(int maxSize)` — um cache LRU: iteração do **menos** para o **mais** recentemente
  acessado e remoção automática do mais antigo ao passar de `maxSize`.
