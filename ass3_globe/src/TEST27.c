/*
 ============================================================================
 Name        : TEST27.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"


#define TO_INT(Element) (*(int*)(Element))

bool equal_Function(Element Element1,Element Element2){
	return (bool)(TO_INT(Element1) == TO_INT(Element2));
}
status print_Function(Element Element){
	printf("%d",TO_INT(Element));
	return 0;
}
Element copy_Function(Element ElementCom){
	int* j;
	j = (int*)malloc(sizeof(int));
	*j = TO_INT(ElementCom);
	return j;
}
status free_Function(Element Element){
	free(Element);
	return 0;
}

int main(void) {
	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */


	int j;
	linkedlist linkedlist1 = createLinkedList(equal_Function,print_Function,copy_Function,free_Function);
	for( j=0; j<20; j++){
		appendNode(linkedlist1,&j);
	}
	int i = 8;
	status statusOut = deleteNode(linkedlist1,&i);
	if (statusOut == 0){
		printf("%d",statusOut);
	}
	i=100;
	statusOut = deleteNode(linkedlist1,&i);
	if (statusOut == 1){
		printf("%d",statusOut);
	}

	displayList(linkedlist1);
	i=18;
	statusOut = deleteNode(linkedlist1,&i);
	if (statusOut == 1){
		printf("%d",statusOut);
	}
	displayList(linkedlist1);
	destroyList(linkedlist1);



	return EXIT_SUCCESS;
}
