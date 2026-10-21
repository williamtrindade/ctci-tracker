# 7.12 Hash Table — Tabela Hash

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.12**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.HashTable<K, V>` **sem usar** `java.util.HashMap`/`Hashtable`:
`new HashTable<>(int capacity)`, `V put(K key, V value)` (retorna o valor antigo ou `null`), `V get(K key)`,
`V remove(K key)`, `boolean containsKey(K key)`, `int size()`. Chaves `null` não são permitidas
(`IllegalArgumentException`). Para manter O(1) médio com muitos elementos, faça *resize* quando a tabela ficar cheia.
