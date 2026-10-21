# 12.9 Smart Pointer — Ponteiro Inteligente

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.9**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.SmartPointer<T>`:

* `new SmartPointer<>(T object, Consumer<T> deleter)` — contagem começa em 1;
* `SmartPointer<T> copy()` — outro smart pointer para o **mesmo** objeto (incrementa a contagem compartilhada);
* `T get()` — o objeto (lança `IllegalStateException` se este smart pointer já foi liberado);
* `void release()` — libera esta referência (idempotente); quando a contagem chega a 0, chama o `deleter` **uma vez**;
* `int refCount()`.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_9_smart_pointer.cpp`](../../../../cpp/12_9_smart_pointer.cpp)
