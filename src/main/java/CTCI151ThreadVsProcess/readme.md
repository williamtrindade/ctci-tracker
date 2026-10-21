# 15.1 Thread vs. Process — Thread vs. Processo

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (observando a diferença):**

* `int incrementWithThreads(int threads, int incrementsEach)` — várias threads incrementam **o mesmo** contador
  (threads compartilham memória); retorne o valor final (use sincronização/atômicos para não perder incrementos);
* `Set<Long> processIdsSeenByThreads(int threads)` — cada thread registra `ProcessHandle.current().pid()`; todas estão no
  mesmo processo;
* `long startChildProcessAndGetPid()` — inicie **outro processo** (ex.: `java -version` com o executável da JVM atual
  via `ProcessHandle.current().info().command()`), espere ele terminar e retorne o pid dele.
