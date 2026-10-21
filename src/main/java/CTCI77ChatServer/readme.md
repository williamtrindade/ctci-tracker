# 7.7 Chat Server — Servidor de Chat

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 7, questão/question **7.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (o "UserManager" + conversas do livro, em memória):** `Message` e `UserStatus` já existem. Implemente
`Solution.ChatServer`:

* `int addUser(String name)` — retorna o id (0, 1, 2, …). `String getUserName(int id)`.
* Amizade: `void sendFriendRequest(int from, int to)`, `void approveFriendRequest(int to, int from)`,
  `void rejectFriendRequest(int to, int from)`, `boolean areFriends(int a, int b)`, `List<Integer> pendingRequests(int
  userId)` (ids de quem enviou pedidos para `userId`, na ordem). Aprovar/rejeitar um pedido inexistente lança
  `IllegalStateException`.
* Status: `void setStatus(int userId, UserStatus status)`, `UserStatus getStatus(int userId)` (padrão `OFFLINE`).
* Conversas: `int startPrivateChat(int a, int b)` (só entre amigos, senão `IllegalStateException`; se já existir
  conversa privada entre os dois, retorna a mesma), `int createGroupChat(int creator, List<Integer> members)`,
  `void addToGroup(int chatId, int userId)`, `void sendMessage(int chatId, int senderId, String content)` (remetente
  precisa participar, senão `IllegalStateException`), `List<Message> getMessages(int chatId)`.
