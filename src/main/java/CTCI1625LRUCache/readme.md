# 16.25 LRU Cache — Cache LRU

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 16, questão/question **16.25**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.LRUCache` **sem usar `LinkedHashMap`**: `new LRUCache(int maxSize)`,
`String getValue(int key)` (`null` se ausente; conta como uso), `void setKeyValue(int key, String value)` (inserir ou
atualizar conta como uso), `boolean removeKey(int key)` e `int size()`. Todas as operações em O(1).
