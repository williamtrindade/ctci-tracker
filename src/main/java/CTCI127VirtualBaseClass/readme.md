# 12.7 Virtual Base Class — Destrutor Virtual

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (análogo em Java com `AutoCloseable`):** implemente dentro de `Solution`:

* `Base implements AutoCloseable` — `new Base(List<String> log)` adiciona `"Base opened"`; `close()` adiciona
  `"Base closed"`;
* `Derived extends Base` — o construtor adiciona `"Derived opened"` (depois do construtor da base); `close()` adiciona
  `"Derived closed"` e **depois** fecha a base.

Fechar um `Derived` através de uma referência `Base` precisa liberar os recursos das duas classes, na ordem inversa da
construção (como os destrutores em C++).

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_7_virtual_base_class.cpp`](../../../../cpp/12_7_virtual_base_class.cpp)
