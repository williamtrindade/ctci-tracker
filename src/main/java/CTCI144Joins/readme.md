# 14.4 Joins

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 14, questão/question **14.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** com as tabelas do exemplo do livro

```
RegularBeverages (Name, Code)          CalorieFreeBeverages (Code, Name)
Budweiser  BUDWEISER                   COCACOLA  Diet Coca-Cola
Coca-Cola  COCACOLA                    FRESCA    Fresca
Pepsi      PEPSI                       PEPSI     Diet Pepsi
                                       PEPSI     Pepsi Light
                                       PURITY    Water
```

implemente `innerJoin()`, `leftOuterJoin()`, `rightOuterJoin()` e `fullOuterJoin()`, cada um retornando um SQL com as
colunas `RegularName, CalorieFreeName` (os nomes de cada tabela), juntando por `Code`. Dica: o H2 não suporta
`FULL OUTER JOIN` — monte com `UNION`.
