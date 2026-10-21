# 12.10 Malloc

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.10**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Memory` (pronta) simula o heap: `int malloc(int bytes)` (endereços **sem** alinhamento garantido),
`void free(int address)` (só aceita endereços devolvidos por `malloc`), `writeInt`/`readInt` (4 bytes; acesso fora de
um bloco alocado lança exceção — "segfault") e `int allocatedBlocks()`. Implemente
`int alignedMalloc(Memory memory, int requiredBytes, int alignment)` e `void alignedFree(Memory memory, int p)` usando
**apenas** essa API.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_10_malloc.cpp`](../../../../cpp/12_10_malloc.cpp)
