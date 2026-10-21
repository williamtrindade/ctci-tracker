# 13.6 Object Reflection — Reflexão

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 13, questão/question **13.6**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** `Rectangle` (com um campo privado `secret`) já existe. Implemente com a API de reflexão
(`java.lang.reflect`):

* `Object newInstance(String className, Object... args)` — cria um objeto chamando o construtor público com a mesma
  quantidade de parâmetros;
* `Object invoke(Object target, String methodName, Object... args)` — chama o método público com esse nome e quantidade
  de parâmetros (lança `NoSuchMethodException` se não existir);
* `List<String> declaredFieldNames(Class<?> type)` — nomes dos campos declarados, em ordem alfabética;
* `Object readPrivateField(Object target, String fieldName)` — lê um campo privado.
