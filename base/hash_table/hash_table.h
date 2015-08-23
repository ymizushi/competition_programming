#ifndef __HASH_TALBE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define __HASH_TALBE_H


#define __HASH_TABLE_SIZE 100

typedef struct map {
    char *key;
    int value;
} Map;

typedef struct hash_table {
    Map map[__HASH_TABLE_SIZE];
} HashTable;

#endif
