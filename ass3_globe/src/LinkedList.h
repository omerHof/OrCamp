/*
 * LinkedList.h
 *
 *  Created on: Nov 24, 2018
 *      Author: ise
 */

#ifndef LINKEDLIST_H_
#define LINKEDLIST_H_

#include "Defs.h"

typedef struct s_linkedlist* linkedlist;



linkedlist createLinkedList(equalFunction equalFunction,printFunction printFunction,copyFunction CopyFunction,freeFunction freeFunction);
void destroyList (linkedlist linked_list);
status appendNode (linkedlist linkedlist,Element ElementAdd);
status deleteNode (linkedlist linkedlist, Element ElementDelet);
void displayList (linkedlist linkedlist);
Element searchInList (linkedlist linkedlist, Element ElementComp);



#endif /* LINKEDLIST_H_ */
