# 6.5 Jugs of Water — Jarros de Água

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 6, questão/question **6.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (generalizado):** implemente `List<int[]> solve(int capacityA, int capacityB, int target)`. Retorne a
sequência de estados `{litrosA, litrosB}` começando em `{0, 0}` e terminando quando algum jarro tem exatamente
`target` litros. Cada passo é uma operação: encher A ou B, esvaziar A ou B, ou despejar um no outro (até esvaziar a
origem ou encher o destino). Retorne a sequência **mais curta** possível, ou `null` se for impossível.
