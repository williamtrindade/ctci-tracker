# 7.5 Online Book Reader — Leitor de Livros Online

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Book` e `User` já existem. Implemente `Solution.OnlineReaderSystem`:

* Biblioteca: `void addBook(Book)`, `boolean removeBook(int bookId)`, `Book findBook(int bookId)`.
* Usuários: `void addUser(User)`, `User findUser(int userId)`, `void setActiveUser(int userId)` (usuário inexistente →
  `IllegalArgumentException`).
* Leitura (para o usuário ativo; sem usuário ativo → `IllegalStateException`): `void openBook(int bookId)`,
  `int getCurrentPage()`, `void turnPageForward()`, `void turnPageBackward()` (a página fica entre 1 e `book.pages()`).
* Cada usuário **retoma** um livro na última página em que parou (ao abrir um livro pela primeira vez, página 1).
