// CTCI 12.1 Last K Lines
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.1 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_1_last_k_lines.cpp -o out && ./out arquivo.txt

#include <fstream>
#include <iostream>
#include <string>

using namespace std;

void printLast10Lines(char* fileName) {
    // TODO: imprima as últimas 10 linhas do arquivo (dica: leia o arquivo uma única vez)
}

int main(int argc, char** argv) {
    if (argc > 1) {
        printLast10Lines(argv[1]);
    } else {
        cout << "uso: ./out <arquivo>" << endl;
    }
    return 0;
}
