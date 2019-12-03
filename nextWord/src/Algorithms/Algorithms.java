package Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class Algorithms {


    protected ArrayList<Word> dataBase;


    /**
     * help method to getFiveCommonWords method
     * @param word
     * @return
     */

    protected int getElementPostion (Word word){
        for(int i=0;i<dataBase.size();i++){
            if(dataBase.get(i).equals(word)){
                return i;
            }
        }
        return 0;
    }


}
