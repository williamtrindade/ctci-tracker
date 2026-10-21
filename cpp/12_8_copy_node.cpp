// CTCI 12.8 Copy Node
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.8 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_8_copy_node.cpp -o out && ./out

#include <iostream>
#include <map>

using namespace std;

struct Node {
    Node* ptr1 = nullptr;
    Node* ptr2 = nullptr;
};

typedef map<Node*, Node*> NodeMap;

Node* copy_structure(Node* root) {
    // TODO: cópia profunda que preserva nós compartilhados e ciclos
    return nullptr;
}

int main() {
    Node* a = new Node();
    Node* b = new Node();
    a->ptr1 = b;
    a->ptr2 = b; // b compartilhado
    b->ptr1 = a; // ciclo
    Node* copy = copy_structure(a);
    if (copy) {
        cout << "copia diferente do original: " << (copy != a) << endl;
        cout << "compartilhamento mantido:    " << (copy->ptr1 == copy->ptr2) << endl;
        cout << "ciclo mantido:               " << (copy->ptr1->ptr1 == copy) << endl;
    }
    return 0;
}
