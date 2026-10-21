# 12.5 Shallow vs Deep Copy — Cópia Rasa vs Profunda

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Person` e `Address` (mutáveis) já existem. Implemente `static Person shallowCopy(Person p)` (novo
`Person` que **compartilha** o mesmo `Address` e a mesma lista de telefones) e `static Person deepCopy(Person p)` (copia
tudo: alterar a cópia não pode afetar o original).

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_5_shallow_vs_deep_copy.cpp`](../../../../cpp/12_5_shallow_vs_deep_copy.cpp)
