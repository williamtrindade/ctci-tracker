# 16.7 Number Max — Máximo sem Comparação

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 16, questão/question **16.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Assinatura:** `int getMax(int a, int b)` — sem `if`, `?:`, `<`, `>`, `Math.max` etc. Cuidado com overflow em `a - b`
(ex.: `a = Integer.MAX_VALUE`, `b = -15`).
