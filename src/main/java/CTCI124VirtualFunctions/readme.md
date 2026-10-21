# 12.4 Virtual Functions — Funções Virtuais

> 📖 **Enunciado / Prompt:** *Cracking the Coding Interview*, 6th ed. — Capítulo/Chapter 12, questão/question **12.4**.
> Leia o enunciado no livro antes de começar. / Read the prompt in the book first.

**Exercício:** em Java, todo método de instância não-final é "virtual" (despacho dinâmico) e métodos `static` são
resolvidos pelo tipo da **referência** (ligação estática), como funções não-virtuais em C++. Implemente dentro de
`Solution`:

* `abstract class Shape` com `abstract double area()`, `String name()` (retorna `"shape"`, sobrescrito nas subclasses),
  `String describe()` (**não** sobrescrito: `name() + " with area " + String.format("%.2f", area())`) e
  `static String staticName()` (retorna `"shape"`);
* `Circle(double radius)` e `Square(double side)` sobrescrevendo `area()` e `name()` (`"circle"`, `"square"`) e
  **escondendo** `staticName()` (retornam `"circle"`, `"square"`);
* `static List<String> describeAll(List<Shape> shapes)`.

**Versão em C/C++ (fiel ao livro, sem testes):** [`cpp/12_4_virtual_functions.cpp`](../../../../cpp/12_4_virtual_functions.cpp)
