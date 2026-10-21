// CTCI 12.11 2D Alloc
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.11 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_11_2d_alloc.cpp -o out && ./out

#include <cstdio>
#include <cstdlib>

int** my2DAlloc(int rows, int cols) {
    // TODO: tente fazer com uma única chamada a malloc
    return nullptr;
}

void my2DDealloc(int** arr) {
    // TODO: libere o que my2DAlloc alocou
}

int main() {
    int rows = 3;
    int cols = 4;
    int** arr = my2DAlloc(rows, cols);
    if (arr) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                arr[i][j] = i * 10 + j;
        printf("arr[2][3] = %d (esperado 23)\n", arr[2][3]);
        my2DDealloc(arr);
    }
    return 0;
}
