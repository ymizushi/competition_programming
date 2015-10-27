#ifndef __HASH_TALBE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define __HASH_TALBE_H

#define __HASH_TABLE_SIZE 100

typedef struct value {
    int id;
    char *value;
    struct value *next_value;
} Value;

typedef struct hash_table {
    Value *value_array[__HASH_TABLE_SIZE];
} HashTable;

#endif
