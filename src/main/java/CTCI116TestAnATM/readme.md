# 11.6 Test an ATM — Testar um Caixa Eletrônico

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 11, questão/question **11.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `AtmResult` já existe. Implemente `Solution.Bank` e `Solution.Atm` (vários caixas compartilham o mesmo
banco):

* `Bank`: `void openAccount(String id, String pin, long balance)`, `long getBalance(String id)`.
* `Atm`: `new Atm(Bank bank, long cash)`, `long getCash()`,
  `AtmResult withdraw(String id, String pin, long amount, LocalDate date)` e
  `AtmResult deposit(String id, String pin, long amount)`.
* Regras do `withdraw`, verificadas nesta ordem: conta inexistente → `UNKNOWN_ACCOUNT`; conta bloqueada →
  `ACCOUNT_LOCKED`; PIN errado → `WRONG_PIN` (o **3º erro seguido** bloqueia a conta; um acerto zera o contador);
  `amount <= 0` ou não múltiplo de 10 → `INVALID_AMOUNT`; saque acima de **1000 por conta por dia** →
  `DAILY_LIMIT_EXCEEDED`; saldo insuficiente → `INSUFFICIENT_FUNDS`; caixa sem notas suficientes → `ATM_OUT_OF_CASH`;
  senão `OK`. `deposit` segue as mesmas regras de conta/PIN e exige `amount > 0` (aumenta o saldo e o dinheiro do caixa).
* **Concorrência:** saques simultâneos em caixas diferentes na mesma conta nunca podem deixar o saldo negativo.
