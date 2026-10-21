// CTCI 12.4 Virtual Functions
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.4 (leia no livro).
//
// Parte escrita: explique abaixo (vtable, vptr, ligação dinâmica).
// Parte prática: complete as classes e compare a saída com e sem a palavra "virtual" em Shape::circumference.
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_4_virtual_functions.cpp -o out && ./out

#include <iostream>

using namespace std;

/*
 * Como funcionam:
 *   TODO: ...
 */

class Shape {
public:
    int edge_length = 1;

    // TODO: experimente com e sem "virtual"
    virtual int circumference() {
        cout << "Circumference of Base Class" << endl;
        return 0;
    }

    virtual ~Shape() = default;
};

class Triangle : public Shape {
public:
    // TODO: sobrescreva circumference() (imprima "Circumference of Triangle Class" e retorne 3 * edge_length)
};

int main() {
    Shape* x = new Shape();
    x->circumference();
    Shape* y = new Triangle();
    y->circumference(); // qual versão é chamada? por quê?
    delete x;
    delete y;
    return 0;
}
