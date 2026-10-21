# 16.22 Langton's Ant — Formiga de Langton

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 16, questão/question **16.22**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Position(row, col)`, `Orientation` e `AntState` já existem. Implemente `AntState simulate(int k)`:
começa em `(0, 0)` virada para `RIGHT`, grade toda branca; linhas crescem **para baixo** (andar `UP` faz `row - 1`).
Retorne as casas pretas, a posição e a orientação finais. (Use uma estrutura que não dependa do tamanho da grade.)
