// CTCI 12.7 Virtual Base Class
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.7 (leia no livro).
//
// Parte prática: complete os destrutores e rode com e sem "virtual" em ~Foo(). Compare a saída.
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_7_virtual_base_class.cpp -o out && ./out

#include <iostream>

using namespace std;

/*
 * Por quê:
 *   TODO: ...
 */

class Foo {
public:
    void f();
    // TODO: destrutor que imprime "~Foo" (experimente com e sem virtual)
};

class Bar : public Foo {
public:
    void f();
    // TODO: destrutor que imprime "~Bar"
};

int main() {
    Foo* p = new Bar();
    delete p; // quais destrutores são chamados?
    return 0;
}
