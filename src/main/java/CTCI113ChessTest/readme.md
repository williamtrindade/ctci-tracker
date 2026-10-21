# 11.3 Chess Test — Teste de Xadrez

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 11, questão/question **11.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `boolean canMoveTo(PieceType type, int fromX, int fromY, int toX, int toY)` num **tabuleiro
vazio** 8x8 (coordenadas 0–7). Regras: `KING` uma casa em qualquer direção; `ROOK` linhas/colunas; `BISHOP` diagonais;
`QUEEN` linhas, colunas e diagonais; `KNIGHT` em "L". Retorne `false` para destino (ou origem) fora do tabuleiro e para
destino igual à origem. Os testes seguem as categorias do livro: casos extremos e casos gerais.
