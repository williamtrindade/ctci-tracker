# Site de progresso

Uma única página estática (`index.html`, sem build nem dependências): capa do livro, objetivo do repositório e uma
grade com as 189 questões para marcar o que já foi resolvido. Abre em inglês; as bandeiras no topo trocam para
português. O progresso e o idioma ficam só no navegador (`localStorage`).

Ao marcar uma questão aparece um aviso com **Compartilhar**, e o botão **Compartilhar** do painel gera o card do
progresso geral. A imagem é desenhada em canvas em dois formatos, horizontal (1200×630, para LinkedIn/X) e story
(1080×1920, para Instagram/WhatsApp), e dá para baixar, copiar ou enviar pelo compartilhamento do celular. Os botões das redes (LinkedIn, X,
WhatsApp, Facebook, Telegram, Instagram) abrem o post já com texto e link, e antes copiam a imagem (ou baixam, se o
navegador não deixar copiar), porque nenhuma delas aceita imagem por link.

- **Rodar localmente:** `python3 -m http.server 8080` nesta pasta e abra `http://localhost:8080/`.
- **Publicar:** o workflow `.github/workflows/pages.yml` publica esta pasta no GitHub Pages a cada push na `main`.
- **Forks:** no GitHub Pages (`<usuario>.github.io/<repo>/`), os links do repositório apontam para o fork de quem está
  usando.
