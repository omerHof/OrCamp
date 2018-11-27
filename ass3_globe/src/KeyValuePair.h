/*
 * KeyValuePair.h
 *
 *  Created on: Nov 24, 2018
 *      Author: ise
 */
#ifndef KEYVALUEPAIR_H_
#define KEYVALUEPAIR_H_

#include "Defs.h"


typedef void* element;
typedef struct s_key_value_pair *key_value_pair;

key_value_pair createKeyValuePair(Element key ,Element value, copyFunction copyValFunc , copyFunction copyKeyFunc, freeFunction freeValFunc,freeFunction freeKeyFunc, printFunction printValFunc,printFunction printKeyFunc,equalFunction equalKeyFunc);
void destroyKeyValuePair (key_value_pair keyValuePair);
void displayValue (key_value_pair keyValuePair);
void displayKey (key_value_pair keyValuePair);
Element getValue (key_value_pair keyValuePair);
Element getKey (key_value_pair keyValuePair);
bool isEqualKey (key_value_pair keyValuePair1,key_value_pair keyValuePair2);
#endif /* KEYVALUEPAIR_H_ */
