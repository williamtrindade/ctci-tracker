# 11.4 No Test Tools — Sem Ferramentas de Teste

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 11, questão/question **11.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício (o "teste de carga caseiro" do livro):** `LoadTestReport` já existe. Implemente
`LoadTestReport loadTest(Callable<Boolean> request, int virtualUsers, int requestsPerUser)`: crie `virtualUsers` threads
que executam `request` `requestsPerUser` vezes **em paralelo**; uma requisição falha se retornar `false` ou lançar
exceção. Meça a latência de cada requisição e preencha o relatório (total, falhas, latência média e máxima em
milissegundos).
