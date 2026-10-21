# 9.3 Web Crawler

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 9, questão/question **9.3**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Page` e a interface `WebFetcher` já existem. Implemente em `Solution`:

* `String normalize(String url)` — host em minúsculas, sem fragmento (`#...`) e sem `/` final (exceto a raiz
  `http://host`). Ex.: `"HTTP://Example.com/a/b/#top"` → `"http://example.com/a/b"`. Mantenha a query string.
* `List<String> crawl(String startUrl, WebFetcher fetcher, int maxPages)` — BFS a partir de `startUrl` retornando as
  URLs **normalizadas** das páginas aceitas, na ordem de visita. Não visite a mesma URL normalizada duas vezes e
  **descarte páginas com conteúdo idêntico** a uma já aceita (ex.: a mesma página com `?sessionId=...`), sem seguir
  seus links. Pare ao aceitar `maxPages` páginas. URLs que `fetch` retornar `null` são ignoradas.
