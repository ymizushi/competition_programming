#include "hash_table.h"

int hash_index(const int id) {
    return id % __HASH_TABLE_SIZE;
}


Value *new_value(int id, char* str) {
    return (Value*)malloc(sizeof(Value));
}

Value *get_value(Value *value, int id) {
    if (value == NULL ) {
        return NULL;
    } else if (value->id == id) {
        return value;
    } else if (value->next_value == NULL) {
        return NULL;
    } else {
        return get_value(value->next_value, id);
    }
}

Value *HashTable_get(HashTable *hashTable, const int id) {
    int index = hash_index(id);
    Value *target = hashTable->value_array[index];
    return get_value(target, id);
}

void HashTable_set(HashTable *hashTable, Value *value) {
    Value *target = HashTable_get(hashTable, value->id);
    if (target == NULL) {
        int index = hash_index(value->id);
        hashTable->value_array[index] = value;
    } else {
        target->next_value = value;
    }
}

int main(int argc, char const* argv[])
{
    HashTable *hashTable = (HashTable*)malloc(sizeof(HashTable));
    Value *value = new_value(0,"hoge"); 
    HashTable_set(hashTable, value);
    Value *result = HashTable_get(hashTable, 0);

    printf("%s\n", result->value);
    free(hashTable);
    return 1;
}

