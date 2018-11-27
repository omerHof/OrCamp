#include "KeyValuePair.h"


struct s_key_value_pair {
	Element key;
	Element value;
	copyFunction copyValFunc;
	copyFunction copyKeyFunc;
	equalFunction equalKeyFunc;
	freeFunction freeValFunc;
	freeFunction freeKeyFunc;
	printFunction printValFunc;
	printFunction printKeyFunc;

};

//func that receives value,key and 4 func and create a pointer to key value pair
key_value_pair createKeyValuePair(Element key ,Element value, copyFunction copyValFunc , copyFunction copyKeyFunc, freeFunction freeValFunc,freeFunction freeKeyFunc, printFunction printValFunc,printFunction printKeyFunc,equalFunction equalKeyFunc){
	key_value_pair newKeyValuePair = (key_value_pair) malloc(sizeof(struct s_key_value_pair));

	if (copyValFunc!=null){
		newKeyValuePair->copyValFunc = copyValFunc;
	}
	if (copyKeyFunc!=null){
		newKeyValuePair->copyKeyFunc = copyKeyFunc;
	}
	if (printValFunc!=null){
		newKeyValuePair->printValFunc = printValFunc;
	}
	if (printKeyFunc!=null){
		newKeyValuePair->printKeyFunc = printKeyFunc;
	}
	if(freeValFunc!=null){
		newKeyValuePair->freeValFunc=freeValFunc;
	}
	if(freeKeyFunc!=null){
		newKeyValuePair->freeKeyFunc=freeKeyFunc;
	}
	if(equalKeyFunc!=null){
		newKeyValuePair->equalKeyFunc=equalKeyFunc;
	}

	if (key!=null){
		newKeyValuePair->key = newKeyValuePair->copyKeyFunc(key);
		//newKeyValuePair->freeKeyFunc(key);

	}
	newKeyValuePair->value = newKeyValuePair->copyKeyFunc(value);
	//newKeyValuePair->freeValFunc(value);

	return newKeyValuePair;
}//createKeyValuePair



//func that erase key value pair and free memory
void destroyKeyValuePair (key_value_pair keyValuePair){
	if(keyValuePair!=null){
		if(keyValuePair->key!=null && keyValuePair->value!=null){
			keyValuePair->freeKeyFunc(keyValuePair->key);
			keyValuePair->freeValFunc(keyValuePair->value);
		}//if
	}//if
	free(keyValuePair);
}//destroyKeyValuePair




//func that display the value
void displayValue (key_value_pair keyValuePair){///return status??????
	if (keyValuePair!=null){
		keyValuePair->printValFunc(keyValuePair->value);
	}//if

}//displayValue

//func that display the key
void displayKey (key_value_pair keyValuePair){///return status??????
	if (keyValuePair!=null){
		keyValuePair->printKeyFunc(keyValuePair->key);
	}//if

}//display key



//func that return the value
Element getValue (key_value_pair keyValuePair){///return status??????
	if(keyValuePair!=null){
		if(keyValuePair->value!=null){
			return keyValuePair->value;//////////need malloc????
		}//if
	}//if
	return null;
}//getValue


//func that return the key
Element getKey (key_value_pair keyValuePair){///return status??????
	if(keyValuePair!=null){
		if(keyValuePair->key!=null){
			return keyValuePair->key;//////////need malloc????
		}//if
	}//if
	return null;
}//getKey


//func that checks if 2 keys are equal
bool isEqualKey (key_value_pair keyValuePair1,key_value_pair keyValuePair2){
	bool isEqual =false;
	if (keyValuePair1!=null && keyValuePair2!=null){
		if (keyValuePair1->equalKeyFunc(keyValuePair1->key,keyValuePair2->key) == true){
			isEqual = true;
		}
	}
	return isEqual;
}





