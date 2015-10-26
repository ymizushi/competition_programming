#include "hash_table.h"

int hash_index(const int id) {
    return id % __HASH_TABLE_SIZE;
}

Value *get_value(Value *value, int id) {
    if (value == NULL ) {
        return NULL;
    } else if (value->id == id) {
        return &value;
    } else if (value->next_value == NULL) {
        return NULL;
    } else {
        return get_value(value->next_value, id);
    }
}

Value *HashTable_get(HashTable *hashTable, const int id) {
    int index = hash_index(id);
    Value *target = &hashTable->value_array[index];
    return get_value(target, id);
}

void HashTable_set(HashTable *hashTable, Value *value) {
    Value *target = HashTable_get(hashTable, value->id)
    if (target == NULL) {
        int index = hash_index(value->id);
        hashTable->value_array[index] = value;
    } else {


    }
}

int main(int argc, char const* argv[])
{
    HashTable *hashTable = (HashTable*)malloc(sizeof(HashTable));

    Map piyo = {"hoge", 1};
    HashTable_set(hashTable, "piyo", &piyo);
    Map *map = HashTable_get(hashTable, "abcd");
    printf("%s\n", map->key);
    printf("%d\n", map->value);
    free(hashTable);
    return 1;
}

