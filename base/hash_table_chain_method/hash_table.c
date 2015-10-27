#include <assert.h>

#include "hash_table.h"

int hash_index(const int id) {
    return id % __HASH_TABLE_SIZE;
}

Value *new_value(int id, char* str) {
    Value *value = (Value*)malloc(sizeof(Value));
    value->id = id;
    value->value = str;
    value->next_value = NULL;
    return value;
}

Value *get_value(Value *value, int id) {
    Value *v;
    for(v=value; v !=NULL; v=v->next_value) {
        if (value->id == id) {
            return value;
        } else {
            ;
        }
    }
    return NULL;
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
    Value *value1 = new_value(0,"hoge"); 
    Value *value2 = new_value(1,"piyo"); 
    Value *value3 = new_value(100,"foo"); 
    // Value *value4 = new_value(101,"bar"); 
    HashTable_set(hashTable, value1);
    HashTable_set(hashTable, value2);
    HashTable_set(hashTable, value3);
    // HashTable_set(hashTable, value4);
    Value *result1 = HashTable_get(hashTable, 0);
    Value *result2 = HashTable_get(hashTable, 1);
    printf("%d", result1->id);
    printf("%s", result1->value);
    printf("%d", result2->id);
    printf("%s", result2->value);
    // assert(result->value != NULL);

    free(hashTable);
    return 1;
}

