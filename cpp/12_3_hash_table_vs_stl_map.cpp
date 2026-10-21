// CTCI 12.3 Hash Table vs STL Map
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.3 (leia no livro).
//
// Parte escrita: responda nos comentários abaixo.
// Parte prática (opcional): implemente uma hash table simples com encadeamento (array de listas ligadas).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_3_hash_table_vs_stl_map.cpp -o out && ./out

#include <iostream>
#include <list>
#include <map>
#include <string>
#include <vector>

using namespace std;

/*
 * Hash table vs std::map:
 *   TODO: ...
 *
 * Como uma hash table é implementada:
 *   TODO: ...
 *
 * Alternativas para poucas entradas:
 *   TODO: ...
 */

class HashTable {
public:
    explicit HashTable(size_t buckets) {
        // TODO
    }

    void put(const string& key, int value) {
        // TODO
    }

    // Retorna true e preenche value se a chave existir.
    bool get(const string& key, int& value) const {
        // TODO
        return false;
    }
};

int main() {
    HashTable table(16);
    table.put("apple", 1);
    table.put("banana", 2);
    int v;
    cout << (table.get("apple", v) ? v : -1) << endl;   // esperado: 1
    cout << (table.get("cherry", v) ? v : -1) << endl;  // esperado: -1

    map<string, int> stlMap = {{"banana", 2}, {"apple", 1}};
    for (const auto& [k, value] : stlMap) {
        cout << k << " -> " << value << endl; // std::map itera em ordem de chave
    }
    return 0;
}
