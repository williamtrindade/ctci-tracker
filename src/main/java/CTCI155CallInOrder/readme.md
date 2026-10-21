# 15.5 Call In Order — Chamar em Ordem

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 15, questão/question **15.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.Foo` com `void first(Runnable work)`, `void second(Runnable work)` e
`void third(Runnable work)` — cada método executa `work` respeitando a ordem, não importa em que ordem as threads
cheguem. Não use espera ativa (*busy waiting*).
