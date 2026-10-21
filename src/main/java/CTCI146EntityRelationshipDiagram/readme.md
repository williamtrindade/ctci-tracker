# 14.6 Entity-Relationship Diagram — Diagrama Entidade-Relacionamento

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 14, questão/question **14.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** transforme o diagrama em DDL. `String schema()` deve criar (nomes exatos):

* `People (PersonID INT PRIMARY KEY, PersonName VARCHAR, Phone VARCHAR)`;
* `Professionals (PersonID INT PRIMARY KEY, Degree VARCHAR, Experience INT)` — um profissional **é uma** pessoa
  (`PersonID` referencia `People`);
* `Companies (CompanyID INT PRIMARY KEY, CompanyName VARCHAR, Address VARCHAR)`;
* `WorksFor (PersonID INT, CompanyID INT, Salary INT, DateOfJoining DATE)` — relacionamento N:N entre `Professionals`
  e `Companies` (chave primária composta e chaves estrangeiras).
