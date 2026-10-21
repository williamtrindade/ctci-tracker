# 12.3 Hash Table vs STL Map

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** o `std::map` é uma **árvore binária de busca** (ordenada). Implemente `Solution.BstMap<K, V>` (sem usar
`TreeMap`): `V put(K key, V value)` (retorna o valor antigo), `V get(K key)`, `boolean containsKey(K key)`, `int size()`,
`List<K> keys()` (em ordem crescente) e `K firstKey()` / `K lastKey()` (`null` se vazio). `K extends Comparable<K>`.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_3_hash_table_vs_stl_map.cpp`](../../../../cpp/12_3_hash_table_vs_stl_map.cpp)
