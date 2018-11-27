/*
 * Main.c
 *
 *  Created on: Nov 27, 2018
 *      Author: ise
 */

#include "KeyValuePair.h"
#define TO_INT(e) (*(int*)(e));
#define TO_CHAR(e) (*(char*) (e));


//3 func
Element copy_Function_to_value (Element ValuetoCopy){
	char *newChar = (char*) malloc(strlen(ValuetoCopy)+1);
	newChar = strcpy(newChar,ValuetoCopy);
	if (newChar!=null){
		return newChar;
	}
	return null;
}

Element copy_Function_to_key (Element KeytoCopy){
	int *newInt = (int*) malloc(sizeof(int));
	*newInt= *((int*)KeytoCopy);
	if (newInt!=null){
		return newInt;
	}
	return null;
}

status free_Function_to_value (Element ValuetoDelete){
	if (ValuetoDelete==null){
		return failure;
	}

	free(ValuetoDelete);
	return success;
}

status free_Function_to_key (Element KeytoDelete){
	if (KeytoDelete==null){
		return failure;
	}

	free(KeytoDelete);
	return success;
}

bool key_equal_Function (Element key1, Element key2){

	if ((bool)*((int*)key1) == *((int*)key2)){
		return true;
	}
	return false;
}

status print_value_Function (Element valueToPrint){
	if (valueToPrint ==null){
		return failure;
	}
	printf("%s",valueToPrint);
	return success;
}

status print_key_Function (Element keyToPrint){
	if (keyToPrint ==null){
		return failure;
	}
	int print = *((int*)keyToPrint);
	printf("%d",print);
	return success;
}



int main () {
	int key1=1;
	char* value1 = "omer";
	Element key11 = &key1;
	Element value11 = value1;

	int key2 = 2;
	char* value2 = "shir";
	Element key22 = &key2;
	Element value22 = value2;
	key_value_pair pair1 = createKeyValuePair(key11,value11,copy_Function_to_value,copy_Function_to_key,free_Function_to_value,free_Function_to_key,print_value_Function,print_key_Function,key_equal_Function);
	key_value_pair pair2 = createKeyValuePair(key22,value22,copy_Function_to_value,copy_Function_to_key,free_Function_to_value,free_Function_to_key,print_value_Function,print_key_Function,key_equal_Function);
	//print key of pair1
	displayKey(pair1);
	//print value pair2
	displayValue(pair2);
	// check equal func
	bool isEqual = true;
	isEqual = isEqualKey(pair1,pair2);
	//destroy pair 2
	destroyKeyValuePair(pair2);
	destroyKeyValuePair(pair1);
	return 0;
}

