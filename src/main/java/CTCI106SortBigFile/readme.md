# 10.6 Sort Big File — Ordenar Arquivo Grande

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 10, questão/question **10.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (ordenação externa):** implemente `void sortFile(Path input, Path output, int maxLinesInMemory)`: leia no
máximo `maxLinesInMemory` linhas por vez, ordene cada bloco em memória e grave-o num arquivo temporário; depois faça o
**merge de k vias** dos blocos no arquivo de saída. Ordem lexicográfica (`String.compareTo`). Apague os temporários.
