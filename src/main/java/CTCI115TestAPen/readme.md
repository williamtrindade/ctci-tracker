# 11.5 Test a Pen — Testar uma Caneta

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 11, questão/question **11.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** primeiro pense nas perguntas do livro (quem usa? para quê? que superfície? que tinta?). Depois implemente
uma caneta simulada, `Solution.Pen`, que os testes exercitam como no livro (testes de falha, de uso normal e de casos
extremos):

* `new Pen(int inkUnits)` — começa **tampada**;
* `void uncap()`, `void cap()`, `boolean isCapped()`;
* `String write(String text)` — tampada não escreve nada (retorna `""`); cada caractere que **não** é espaço em branco
  gasta 1 unidade de tinta (espaços não gastam); quando a tinta acaba, para de escrever e retorna só o que foi escrito;
* `int inkLeft()`. `inkUnits` negativo → `IllegalArgumentException`.
