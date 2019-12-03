package nextWord;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class generateDataBaseAlgo extends Algorithms {



    /**
     * ALGORITHM to generate the database - array list tht contains all the words in the file, and their subWords.
     * @throws FileNotFoundException
     */

    public ArrayList<Word> generateDataBase () throws IOException {
        dataBase = new ArrayList<>();
        InputStream is = generateDataBaseAlgo.class.getResourceAsStream("/database/database.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        Scanner input = new Scanner(reader);

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
