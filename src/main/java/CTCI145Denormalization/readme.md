# 14.5 Denormalization — Desnormalização

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 14, questão/question **14.5**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** schema normalizado `Teachers (TeacherID, TeacherName)` e `Courses (CourseID, CourseName, TeacherID)`.
Implemente os SQLs:

* `coursesWithTeacherNormalized()` — `CourseName, TeacherName` usando `JOIN`;
* `createDenormalizedTable()` — cria `CoursesDenormalized (CourseID INT PRIMARY KEY, CourseName VARCHAR(100), TeacherID
  INT, TeacherName VARCHAR(100))`;
* `populateDenormalizedTable()` — `INSERT ... SELECT` copiando os dados (com o nome do professor redundante);
* `coursesWithTeacherDenormalized()` — `CourseName, TeacherName` **sem** `JOIN`.

Os testes também mostram o "contra": depois de renomear um professor, a tabela desnormalizada fica desatualizada.
