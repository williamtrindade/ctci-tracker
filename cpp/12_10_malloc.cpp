// CTCI 12.10 Malloc
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.10 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_10_malloc.cpp -o out && ./out

#include <cstdint>
#include <cstdio>
#include <cstdlib>

void* aligned_malloc(size_t required_bytes, size_t alignment) {
    // TODO
    return nullptr;
}

void aligned_free(void* p2) {
    // TODO
}

int main() {
    void* p = aligned_malloc(1000, 128);
    printf("endereco: %p, multiplo de 128? %s\n", p, ((uintptr_t)p % 128 == 0 && p) ? "sim" : "nao");
    aligned_free(p);
    return 0;
}
