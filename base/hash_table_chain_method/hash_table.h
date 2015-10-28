#ifndef __HASH_TALBE_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define __HASH_TALBE_H

#define __HASH_TABLE_SIZE 100

typedef struct hash_table {
    Element *elements[__HASH_TABLE_SIZE];
} HashTable;

HashTable *HashTable_new(); 
void *HashTable_free(HashTable*); 

typedef struct element {
    int id;
    struct value *v;
    struct element *next;
} Element;


Element *Element_new(int, value);

typedef struct value {
    cha* str
} Value;

Element *Element_new(int id, Value *v) {
    Element *element = (Element*)malloc(sizeof(Element));
}



#endif
