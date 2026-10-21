# 12.8 Copy Node — Copiar Nó

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.8**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Node` (com `data`, `ptr1`, `ptr2`) já existe. Implemente `Node copyStructure(Node root)` — cópia
profunda que preserva a **forma** do grafo: nós compartilhados continuam compartilhados na cópia e ciclos continuam
ciclos (cada nó original vira exatamente um nó novo).

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_8_copy_node.cpp`](../../../../cpp/12_8_copy_node.cpp)
