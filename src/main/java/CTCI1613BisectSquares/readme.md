# 16.13 Bisect Squares — Dividir Quadrados ao Meio

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 16, questão/question **16.13**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Assinatura:** `Line cut(Square s1, Square s2)` — `Point`, `Square(left, bottom, size)` e `Line(start, end)` já
existem. A reta deve passar pelo **centro dos dois quadrados**; como no livro, retorne o segmento cujos extremos são os
pontos **mais distantes** onde essa reta cruza as bordas dos quadrados (cada extremo fica na borda de um dos quadrados).
