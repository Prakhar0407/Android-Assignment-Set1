#include <bits/stdc++.h>
using namespace std;

class MyHashMap {
private:
    static const int SIZE = 10007;
    vector<list<pair<int, int>>> table;

    int hash(int key) {
        return key % SIZE;
    }

public:
    MyHashMap() {
        table.resize(SIZE);
    }

    void put(int key, int value) {
        int idx = hash(key);
        for (auto& [k, v] : table[idx]) {
            if (k == key) {
                v = value; 
                return;
            }
        }
        table[idx].emplace_back(key, value);
    }

    int get(int key) {
        int idx = hash(key);
        for (const auto& [k, v] : table[idx]) {
            if (k == key) return v;
        }
        return -1; // Not found
    }

    void remove(int key) {
        int idx = hash(key);
        auto& bucket = table[idx];
        for (auto it = bucket.begin(); it != bucket.end(); ++it) {
            if (it->first == key) {
                bucket.erase(it);
                return;
            }
        }
    }
};

int main() {
    MyHashMap obj;
    obj.put(1, 10);
    obj.put(2, 20);
    cout << obj.get(1) << endl; // 10
    cout << obj.get(3) << endl; // -1
    obj.put(2, 30);
    cout << obj.get(2) << endl; // 30
    obj.remove(2);
    cout << obj.get(2) << endl; // -1
    return 0;
}
