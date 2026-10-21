# 9.8 Pastebin

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.8**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente `Solution.Pastebin` (o tempo vem de um `LongSupplier` em milissegundos, para os testes
controlarem o relógio):

* `new Pastebin(Random random, LongSupplier clock)`;
* `String createPaste(String content, long ttlMillis)` — retorna uma chave **única** de 10 caracteres
  alfanuméricos (`[a-zA-Z0-9]`); `ttlMillis <= 0` = nunca expira. Textos iguais geram chaves diferentes;
* `String getPaste(String key)` — conteúdo ou `null` (inexistente ou expirado); cada leitura bem-sucedida conta uma
  visualização;
* `int getViews(String key)` — visualizações (0 se inexistente).
