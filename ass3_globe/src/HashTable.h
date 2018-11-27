
#ifndef HASH_TABLE_H
#define HASH_TABLE_H
#include  "LinkedList.h"
#include  "KeyValuePair.h"

typedef struct hashTable_s *hashTable;




hashTable createHashTable(copyFunction copyKey, freeFunction freeKey, printFunction printKey, copyFunction copyValue, freeFunction freeValue, printFunction printValue, equalFunction equalKey, transformIntoNumberFunction transformKeyIntoNumber, int hashNumber);
status destroyHashTable(hashTable hashTable);
status addToHashTable(hashTable hashTable, Element key,Element value);
Element lookupInHashTable(hashTable hashTable, Element key);
status removeFromHashTable(hashTable hashTable, Element key);
status displayHashElements(hashTable hashTable);

#endif /* HASH_TABLE_H */
