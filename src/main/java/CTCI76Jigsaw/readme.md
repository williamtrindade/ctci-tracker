# 7.6 Jigsaw — Quebra-cabeça

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Shape`, `Orientation`, `Edge` (com `fitsWith`) e `Piece` (com `rotateEdgesBy`) já existem. Implemente
`Piece[][] solve(List<Piece> pieces, int size)`: retorne a grade `size x size` com cada peça **já girada** na
orientação correta — bordas `FLAT` para fora do quebra-cabeça e bordas vizinhas se encaixando
(`left.getEdge(RIGHT).fitsWith(right.getEdge(LEFT))`, idem para TOP/BOTTOM).
