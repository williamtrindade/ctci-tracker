// CTCI 12.9 Smart Pointer
//
// Enunciado / Prompt: Cracking the Coding Interview, 6th ed., questão 12.9 (leia no livro).
//
// Compilar/rodar (opcional): g++ -std=c++17 -Wall 12_9_smart_pointer.cpp -o out && ./out

#include <iostream>

using namespace std;

template <class T>
class SmartPointer {
public:
    SmartPointer(T* ptr) {
        // TODO
    }

    SmartPointer(SmartPointer<T>& sptr) {
        // TODO
    }

    SmartPointer<T>& operator=(SmartPointer<T>& sptr) {
        // TODO (cuidado com auto-atribuição)
        return *this;
    }

    ~SmartPointer() {
        // TODO
    }

    T& operator*() {
        return *ref; // TODO: ajuste se mudar os membros
    }

    T* operator->() {
        return ref;
    }

protected:
    T* ref = nullptr;
    unsigned* ref_count = nullptr;
};

struct Resource {
    Resource() { cout << "Resource criado" << endl; }
    ~Resource() { cout << "Resource destruido" << endl; }
};

int main() {
    {
        SmartPointer<Resource> p1(new Resource());
        {
            SmartPointer<Resource> p2(p1);
            cout << "duas referencias" << endl;
        }
        cout << "uma referencia" << endl;
    } // esperado: "Resource destruido" só aqui
    return 0;
}
