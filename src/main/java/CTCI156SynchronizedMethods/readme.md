# 15.6 Synchronized Methods — Métodos Sincronizados

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** responda nos métodos de `Solution` (`true` = podem rodar ao mesmo tempo). A classe `Foo` (pronta) e o
teste fazem o experimento de verdade com threads para confirmar cada resposta:

* `canRunSynchronizedOnSameInstance()` — duas threads chamando `A` no **mesmo** objeto;
* `canRunSynchronizedOnDifferentInstances()` — `A` em objetos **diferentes**;
* `canRunSynchronizedAndNormalOnSameInstance()` — `A` e `B` no mesmo objeto;
* `canRunStaticSynchronizedOnDifferentInstances()` — o método `static synchronized C` "via" objetos diferentes.
