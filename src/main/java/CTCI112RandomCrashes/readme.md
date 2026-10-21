# 11.2 Random Crashes — Falhas Aleatórias

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 11, questão/question **11.2**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (um "crash aleatório" clássico em Java):** implemente `Solution.EventBus`:
`Subscription subscribe(Consumer<String> listener)`, `void publish(String event)` e `int subscriberCount()`;
`Subscription.cancel()` remove o listener. Requisitos:

* um listener pode se cancelar (ou inscrever outros) **durante** o `publish` sem lançar
  `ConcurrentModificationException` — o `publish` entrega o evento a quem estava inscrito no **início** da publicação;
* deve ser seguro chamar `subscribe`/`cancel`/`publish` a partir de várias threads ao mesmo tempo.
