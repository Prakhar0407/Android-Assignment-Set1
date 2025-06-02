#include <bits/stdc++.h>
using namespace std;

class LRUCache {
private:
    struct Node {
        int key, value;
        Node* prev;
        Node* next;
        Node(int k, int v) : key(k), value(v), prev(nullptr), next(nullptr) {}
    };

    int capacity;
    unordered_map<int, Node*> cache;
    Node* head; // Most recently
    Node* tail; // Least recently

    // Add node to front (right after head)
    void addNode(Node* node) {
        node->next = head->next;
        node->prev = head;
        head->next->prev = node;
        head->next = node;
    }

    // Remove node from its position
    void removeNode(Node* node) {
        Node* prev = node->prev;
        Node* next = node->next;
        prev->next = next;
        next->prev = prev;
    }

    // Move given node to front
    void moveToFront(Node* node) {
        removeNode(node);
        addNode(node);
    }

    // Pop the least recently used node 
    Node* popTail() {
        Node* node = tail->prev;
        removeNode(node);
        return node;
    }

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        head = new Node(0, 0);  
        tail = new Node(0, 0); 
        head->next = tail;
        tail->prev = head;
    }

    int get(int key) {
        if (cache.find(key) == cache.end()) return -1;
        Node* node = cache[key];
        moveToFront(node);
        return node->value;
    }

    void put(int key, int value) {
        if (cache.find(key) != cache.end()) {
            Node* node = cache[key];
            node->value = value;
            moveToFront(node);
        } else {
            if (cache.size() == capacity) {
                Node* lru = popTail();
                cache.erase(lru->key);
                delete lru;
            }
            Node* newNode = new Node(key, value);
            cache[key] = newNode;
            addNode(newNode);
        }
    }

    ~LRUCache() {
        Node* current = head;
        while (current) {
            Node* next = current->next;
            delete current;
            current = next;
        }
    }
};

// LRUCache lru(2);
// lru.put(1, 1);
// lru.put(2, 2);
// cout << lru.get(1) << endl; // returns 1
// lru.put(3, 3);              // evicts key 2
// cout << lru.get(2) << endl; // returns -1 (not found)
// lru.put(4, 4);              // evicts key 1
// cout << lru.get(1) << endl; // returns -1 (not found)
// cout << lru.get(3) << endl; // returns 3
// cout << lru.get(4) << endl; // returns 4

