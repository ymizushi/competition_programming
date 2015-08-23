#include "hash_table.h"

int hash_index(const char* str) {
    return strlen(str) % __HASH_TABLE_SIZE;
}

Map *HashTable_get(HashTable *hashTable, const char* key) {
    int index = hash_index(key);
    return &hashTable->map[index];
}

void HashTable_set(HashTable *hashTable, const char* key, Map* map) {
    int index = hash_index(key);
    hashTable->map[index] = *map;
}

int main(int argc, char const* argv[])
{
    HashTable *hashTable = (HashTable*)malloc(sizeof(HashTable));

    Map piyo = {"hoge", 1};
    HashTable_set(hashTable, "piyo", &piyo);
    Map *map = HashTable_get(hashTable, "abcd");
    printf("%s\n", map->key);
    printf("%d\n", map->value);
    return 1;
}

