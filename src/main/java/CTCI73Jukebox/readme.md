# 7.3 Jukebox

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Song` já existe. Implemente `Solution.Jukebox`:

* `void addToLibrary(Song song)`;
* `boolean enqueue(String title)` — coloca na fila de reprodução a música da biblioteca com esse título (retorna
  `false` se não existir);
* `Song playNext()` — tira a próxima música da fila e a torna a atual (retorna `null` se a fila estiver vazia; nesse
  caso a música atual também vira `null`);
* `Song getCurrentSong()`, `List<Song> getQueue()` (cópia, na ordem), `List<Song> getHistory()` (músicas já tocadas, na
  ordem).
