# 5.8 Draw Line — Desenhar Linha

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 5, questão/question **5.8**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Regras (como no livro):** `width` é em **pixels**; `x1` e `x2` são inclusivos (`x1 <= x2`); o pixel `x = 0` de cada
byte é o bit **mais significativo** (`0x80`). Pixels fora da linha não podem ser alterados.

**Assinatura:** `void drawLine(byte[] screen, int width, int x1, int x2, int y)`
