/*
 * LinkedList.c

 *
 *  Created on: Nov 24, 2018
 *      Author: ise
 */

#include "LinkedList.h"


static int searchInListIndex (linkedlist linkedlist, Element ElementComp);

struct s_linkedlist{
	Element* Array;
	int size;
	printFunction printFunction;
	equalFunction equalFunction;
	copyFunction copyFunction;
	freeFunction freeFunction;
};

//func 1
linkedlist createLinkedList(equalFunction equalFunction,printFunction printFunction,copyFunction CopyFunction,freeFunction freeFunction){
    linkedlist linked_list = (linkedlist)malloc(sizeof(struct s_linkedlist));
    linked_list->printFunction = printFunction;
    linked_list->equalFunction = equalFunction;
    linked_list->copyFunction = CopyFunction;
    linked_list->freeFunction = freeFunction;
    linked_list->Array = (Element*)malloc(sizeof(Element));
    linked_list->size =0;
    return linked_list;
}//createLinkedList

//func 2
void destroyList (linkedlist linked_list){
    int i=0;
    for(i=0; i<linked_list->size; i++){
    	linked_list->freeFunction(linked_list->Array[i]);
    }
    linked_list->freeFunction(linked_list->Array);
      free(linked_list);
}//destroyList

//func 3
status appendNode (linkedlist linked_list,Element ElementAdd){
    status statusOut = 1; //failure
    if (ElementAdd == null || linked_list == null) { // failure
        statusOut = 1;
        return statusOut;
    }
    if(searchInList(linked_list,ElementAdd) != null){//if the ElementAdd found in linkedlist then return failure
        return statusOut; //failure
    }//if
    statusOut =1;//failure
    Element ElementCopy = linked_list->copyFunction(ElementAdd);
    linked_list->size = (linked_list->size) +1;
    linked_list->Array = (Element*)realloc(  linked_list->Array,sizeof(Element)*linked_list->size);
    if( linked_list->Array == null){ // failure
        destroyList(linked_list);
        return statusOut;
    }//if
    statusOut=0;
    linked_list->Array[linked_list->size-1] = ElementCopy;
     return statusOut;
}//appendNode


//func 4
status deleteNode (linkedlist linkedlist, Element ElementDelet){
  status statusOut = 1;
     if (ElementDelet == null || linkedlist == null) { // failure
        return statusOut;
    }//if
    if(searchInList(linkedlist,ElementDelet) == null){//if the ElementAdd not found in linkedlist then return failure
        return statusOut; //failure
    }//if
    Element ElementToRemove = searchInList(linkedlist,ElementDelet);
    int index = searchInListIndex(linkedlist,ElementDelet);
     Element holdRemove = linkedlist->Array[index];
    linkedlist->Array[index] =  linkedlist->Array[linkedlist->size-1];
    free(holdRemove);
    linkedlist->size = linkedlist->size - 1;
    linkedlist->Array = (Element*)realloc(linkedlist->Array,sizeof(Element)*linkedlist->size);
    if ( linkedlist->Array == null){
        destroyList(linkedlist);
        return statusOut;
    }
    statusOut = 0;
    return statusOut;
 }//deleteNode

 //func 5
void displayList (linkedlist linkedlist){
    if (linkedlist == null) { // failure
        //Nothing
    }//if
    else{
    	int i=0;
        for(i=0; i<linkedlist->size; i++){
        	linkedlist->printFunction(linkedlist->Array[i]);
        }//for
    }//else
}//displayList


//func 6
Element searchInList (linkedlist linkedlist, Element ElementComp){
    if (ElementComp == null || linkedlist == null) { // failure
        return null;
    }//if
    int i=0; 
    for(i=0; i<linkedlist->size; i++){
        if(linkedlist->equalFunction(linkedlist->Array[i],ElementComp) == 1){
            return ((Element)linkedlist->Array[i]);
        }//if
    }//for
    return null;
}//searchInList


//func help
static int searchInListIndex (linkedlist linkedlist, Element ElementComp){
    int i=0; 
    for(i=0; i<linkedlist->size; i++){
        if(linkedlist->equalFunction(linkedlist->Array[i],ElementComp) == 1){
            return i;
        }//if
    }//for
    return -1;
}//searchInListIndex
