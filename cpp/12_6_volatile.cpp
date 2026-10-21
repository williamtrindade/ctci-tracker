// CTCI 12.6 Volatile
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.6 (leia no livro).
//
// Parte escrita: responda abaixo.
// Parte prática (opcional): escreva as declarações pedidas e um exemplo em que, sem volatile, o compilador poderia
// otimizar um laço que espera uma variável mudar "por fora".
//
// Compilar (opcional): g++ -std=c++17 -Wall -O2 12_6_volatile.cpp -o out

/*
 * Significado de volatile:
 *   TODO: ...
 *
 * Declare (e explique a diferença):
 *   TODO: um int volátil
 *   TODO: um ponteiro para um int volátil
 *   TODO: um ponteiro volátil para um int não volátil
 *   TODO: um ponteiro volátil para um int volátil
 */

int opt = 1; // TODO: o que muda se for "volatile int opt"?

void fn() {
    // TODO: escreva um laço que espera opt mudar (como no exemplo do livro)
}

int main() {
    return 0;
}
