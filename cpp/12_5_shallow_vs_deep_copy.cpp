// CTCI 12.5 Shallow vs Deep Copy
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.5 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_5_shallow_vs_deep_copy.cpp -o out && ./out

#include <cstdio>
#include <cstdlib>
#include <cstring>

/*
 * Diferença e quando usar cada uma:
 *   TODO: ...
 */

struct Test {
    char* ptr;
};

void shallow_copy(Test& src, Test& dest) {
    // TODO
}

void deep_copy(Test& src, Test& dest) {
    // TODO
}

int main() {
    Test a;
    a.ptr = (char*)malloc(6);
    strcpy(a.ptr, "hello");

    Test shallow{};
    Test deep{};
    shallow_copy(a, shallow);
    deep_copy(a, deep);

    if (a.ptr) a.ptr[0] = 'J'; // altera o original
    printf("shallow: %s\n", shallow.ptr ? shallow.ptr : "(null)"); // esperado: "Jello" (compartilha)
    printf("deep:    %s\n", deep.ptr ? deep.ptr : "(null)");       // esperado: "hello" (cópia própria)

    free(a.ptr);
    if (deep.ptr) free(deep.ptr);
    return 0;
}
