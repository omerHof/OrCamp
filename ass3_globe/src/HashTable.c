/*
 * HashTable.c
 *
 *  Created on: Nov 27, 2018
 *      Author: ise
 */

#include "HashTable.h"
static int returnIndex(hashTable hashTable,Element ElementKey);

struct hashTable_s{
	copyFunction copyKey;
	freeFunction freeKey;
	printFunction printKey;
	copyFunction copyValue;
	freeFunction freeValue;
	printFunction printValue;
	equalFunction equalKey;
	transformIntoNumberFunction transformKeyIntoNumber;
	int hashNumber;
	linkedlist* linked_list;

};

hashTable createHashTable(copyFunction copyKey, freeFunction freeKey, printFunction printKey, copyFunction copyValue, freeFunction freeValue, printFunction printValue, equalFunction equalKey, transformIntoNumberFunction transformKeyIntoNumber, int hashNumber){
	hashTable hashTable_pointer=(hashTable)malloc(sizeof(struct hashTable_s));
	hashTable_pointer->copyKey = copyKey;
	hashTable_pointer->copyValue = copyValue;
	hashTable_pointer->equalKey = equalKey;
	hashTable_pointer->freeKey = freeKey;
	hashTable_pointer->freeValue =freeValue;
	hashTable_pointer->transformKeyIntoNumber =transformKeyIntoNumber;
	hashTable_pointer->printValue = printValue;
	hashTable_pointer->printKey=printKey;
	hashTable_pointer->hashNumber = hashNumber;
	hashTable_pointer->linked_list = (linkedlist*)malloc(sizeof(linkedlist)*hashNumber);
	int i=0;
	for(i=0; i<hashNumber;i++){
		hashTable_pointer->linked_list[i]= createLinkedList(hashTable_pointer->equalKey,hashTable_pointer->printValue,);
	}//for


	return hashTable_pointer;
}//createHashTable



status destroyHashTable(hashTable hashTable){
	status statusOut = 1;




	return statusOut;

}//destroyHashTable



status addToHashTable(hashTable hashTable_pointer, Element key,Element value){
	///copy!!!!!!!!!!!!!!!!!
	status statusOut = 1;
	key_value_pair key_value_pair =createKeyValuePair(key,value,hashTable_pointer->copyValue,hashTable_pointer->copyKey,hashTable_pointer->freeValue,hashTable_pointer->freeKey,hashTable_pointer->printValue,hashTable_pointer->printKey,hashTable_pointer->equalKey);
	int index = 0;
	index =returnIndex(hashTable_pointer,key);
	statusOut =appendNode(hashTable_pointer->linked_list[index],key_value_pair);
	return statusOut;
}//addToHashTable


static int returnIndex(hashTable hashTable,Element ElementKey){
	int j=0;
	j =hashTable->transformKeyIntoNumber(ElementKey);
	int out = j%hashTable->hashNumber;
	return out;
}//returnIndex



Element lookupInHashTable(hashTable hashTable_pointer, Element key){
	key_value_pair key_value_pair =createKeyValuePair(key,null,hashTable_pointer->copyValue,hashTable_pointer->copyKey,hashTable_pointer->freeValue,hashTable_pointer->freeKey,hashTable_pointer->printValue,hashTable_pointer->printKey,hashTable_pointer->equalKey);
	int i=0;
	for(i=0; i<hashTable_pointer->hashNumber; i++){
		if (searchInList(hashTable_pointer->linked_list[i],key_value_pair) != null){
			return searchInList(hashTable_pointer->linked_list[i],key_value_pair);
		}//if
	}//for
	return null;
}//lookupInHashTable



status removeFromHashTable(hashTable hashTable_pointer, Element key){
	status statusOut = 1;
	int i=0;
	key_value_pair key_value_pair =createKeyValuePair(key,null,hashTable_pointer->copyValue,hashTable_pointer->copyKey,hashTable_pointer->freeValue,hashTable_pointer->freeKey,hashTable_pointer->printValue,hashTable_pointer->printKey,hashTable_pointer->equalKey);
	for(i=0; i<hashTable_pointer->hashNumber; i++){
		if (searchInList(hashTable_pointer->linked_list[i],key_value_pair) != null){
			statusOut = deleteNode(hashTable_pointer->linked_list[i],searchInList(hashTable_pointer->linked_list[i],key_value_pair));
			return statusOut;
		}//if
	}//for
	return statusOut;
}//removeFromHashTable





status displayHashElements(hashTable hashTable){
	status statusOut = 1;




	return statusOut;




}//displayHashElements



