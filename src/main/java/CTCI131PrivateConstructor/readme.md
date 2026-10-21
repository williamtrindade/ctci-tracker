# 13.1 Private Constructor — Construtor Privado

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.1**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** dentro de `Solution`:

* `Shape` deve ter **somente construtores privados**. Ainda assim, as classes **aninhadas** `Shape.Circle(double
  radius)` e `Shape.Square(double side)` conseguem estendê-la (implemente `area()`); exponha fábricas
  `static Shape circle(double r)` e `static Shape square(double s)`.
* `Registry` é um *singleton*: construtor privado e `static Registry getInstance()` sempre retornando a mesma instância.

O stub vem com construtores **públicos** — torne-os privados (os testes verificam por reflexão).
