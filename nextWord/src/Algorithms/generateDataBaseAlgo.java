package Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class generateDataBaseAlgo extends Algorithms {



    /**
     * ALGORITHM to generate the database - array list tht contains all the words in the file, and their subWords.
     * @throws FileNotFoundException
     */

    public ArrayList<Word> generateDataBase () throws FileNotFoundException {
        dataBase = new ArrayList<>();
        File file = new File("database/text.txt");
        Scanner input = new Scanner(file);

        Word first = new Word("");
        if(input.hasNext()){
            first = new Word(input.next());
        }
        while (input.hasNext()) {
            Word word = new Word(input.next());
            if (!dataBase.contains(word)){
                dataBase.add(word);
            }
            if (!first.getNextWord().containsKey(word)){
                first.getNextWord().put(word,1);
            } else {
                int counter = first.getNextWord().get(word);
                counter++;
                first.getNextWord().put(word,counter);
            }
            dataBase.add(first);
            first=dataBase.remove(getElementPostion(word));
        }
        return dataBase;
    }

}
