# 7.11 File System — Sistema de Arquivos

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.11**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** implemente as classes dentro de `Solution`:

* `Entry` (abstrata): `getName()`, `getParent()`, `String getFullPath()` (ex.: `/home/docs/a.txt`; a raiz tem nome
  vazio e caminho `/`), `abstract int size()`, `boolean delete()` (remove do diretório pai; a raiz não pode ser
  removida → `false`), `void rename(String newName)`.
* `File extends Entry`: `new File(String name, Directory parent, String content)`; `size()` = tamanho do conteúdo;
  `getContent()`/`setContent()`.
* `Directory extends Entry`: `new Directory(String name, Directory parent)` (com `parent == null` é a raiz);
  `size()` = soma recursiva; `int numberOfFiles()` (recursivo, só arquivos); `List<Entry> getContents()`;
  `Entry resolve(String relativePath)` (ex.: `"docs/a.txt"`, `null` se não existir).
* Construtores com `parent != null` já adicionam a entrada no diretório pai.
