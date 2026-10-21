// CTCI 12.2 Reverse String
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.2 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_2_reverse_string.cpp -o out && ./out

#include <cstdio>

void reverse(char* str) {
    // TODO: inverta a string in place (cuidado com o '\0' e com str == NULL)
}

int main() {
    char s[] = "hello world";
    reverse(s);
    printf("%s\n", s); // esperado: "dlrow olleh"
    return 0;
}
