# 15.2 Context Switch — Troca de Contexto

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.2**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `double measureContextSwitchMicros(int roundTrips)`: duas threads fazem "pingue-pongue" (uma
acorda a outra e espera ser acordada, ex.: com `SynchronousQueue` ou `LockSupport.park/unpark`) `roundTrips` vezes.
Cada ida e volta força duas trocas de contexto; retorne o tempo médio estimado de **uma** troca, em microssegundos.
