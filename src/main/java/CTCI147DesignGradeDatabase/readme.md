# 14.7 Design Grade Database — Banco de Notas

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 14, questão/question **14.7**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** com o schema do livro

```
Students (StudentID, StudentName)
Courses (CourseID, CourseName, ProfessorID)
CourseEnrollment (CourseID, StudentID, Grade, Term)
```

`String honorRollQuery()` deve retornar `StudentName, GPA` (GPA = média de `Grade`) dos alunos cuja média é **maior ou
igual à menor média entre os 10% melhores** (assim empates no corte entram, como no livro), ordenado por GPA
decrescente. Dica (H2): `FETCH FIRST 10 PERCENT ROWS ONLY`.
