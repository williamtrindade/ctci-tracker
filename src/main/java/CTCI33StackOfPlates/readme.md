# 3.3 Stack of Plates — Pilha de Pratos

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 3, questão/question **3.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.SetOfStacks`:

* `new SetOfStacks(int capacity)`, `push(int)`, `int pop()`, `int popAt(int index)`, `boolean isEmpty()`,
  `int getNumberOfStacks()`.
* `pop`/`popAt` em estrutura vazia lançam `java.util.EmptyStackException`; `popAt` com índice inválido lança
  `IndexOutOfBoundsException`.
* Implemente o `popAt` **com rollover** (como no livro): depois do `popAt`, os elementos das pilhas seguintes são
  "puxados" para que todas as pilhas, exceto a última, continuem cheias. Pilhas vazias devem ser descartadas.
