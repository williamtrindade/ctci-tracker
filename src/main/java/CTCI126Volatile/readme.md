# 12.6 Volatile

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (o `volatile` do Java):** implemente `Solution.Worker implements Runnable`: `run()` fica em laço
incrementando um contador até `requestStop()` ser chamado **por outra thread**; `long iterations()` e
`boolean isRunning()`. Sem a palavra-chave certa, o JIT pode "cachear" a flag e o laço nunca termina — os testes têm
timeout.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_6_volatile.cpp`](../../../../cpp/12_6_volatile.cpp)
