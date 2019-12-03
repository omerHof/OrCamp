package nextWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchAlgo extends Algorithms {


    public SearchAlgo(ArrayList<Word> dataBaseInput ) {
        dataBase = dataBaseInput;
    }

    /**
     * ALGORITHM to search 5 common subWord for a given word
     * this is the main method
     * @param string
     * @return
     */

    public String[] searchNextWord(String string){
        String[] result = new String[5];
        Word word = new Word(string);
        HashMap<Word,Integer> maxCommon = new HashMap<>();
        if (dataBase.contains(word)){
            maxCommon = getFiveCommonWords(word);
        }

        maxCommon.putAll(allForms(word,'ב'));
        maxCommon.putAll(allForms(word,'ש'));
        maxCommon.putAll(allForms(word,'ל'));
        maxCommon.putAll(allForms(word,'מ'));
        maxCommon.putAll(allForms(word,'ה'));

        for (int i=0;i<5;i++){
            Map.Entry<Word, Integer> maxEntry = null;
            for (Map.Entry<Word, Integer> entry :maxCommon.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }
            if (maxEntry!=null){
                result[i]= maxEntry.getKey().getWord();
                maxCommon.remove(maxEntry.getKey());
                if (maxCommon.isEmpty()){
                    break;
                }
            }
        }
        return result;
    }

    /**
     * help method to search word, change the word and send it to get five common word method
     * @param word
     * @param c
     * @return
     */
    private HashMap<Word,Integer> allForms (Word word, char c){
        HashMap<Word,Integer> maxCommon = new HashMap<>();
        word.setWord(c+word.getWord());
        if (dataBase.contains(word)){
            maxCommon = getFiveCommonWords(word);
        }
        word.setWord(word.getWord().substring(1));
        return maxCommon;
    }

    /**
     * help method to search word method, return 5 commom sub word for a given word
     * @param word
     * @return
     */
    private HashMap<Word,Integer> getFiveCommonWords(Word word){

        HashMap<Word,Integer> tempContainer;
        tempContainer = new HashMap<>();
        if (dataBase.contains(word)){
            Word temp = dataBase.remove(getElementPostion(word));
            for (int i=0;i<5;i++){
                Map.Entry<Word, Integer> maxEntry = null;
                for (Map.Entry<Word, Integer> entry : temp.getNextWord().entrySet())
                {
                    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    {
                        maxEntry = entry;
                    }
                }
                tempContainer.put(maxEntry.getKey(),maxEntry.getValue());
                temp.getNextWord().remove(maxEntry.getKey());
                if (temp.getNextWord().isEmpty()){
                    break;
                }
            }
            temp.getNextWord().putAll(tempContainer);
            dataBase.add(temp);
        }
        return  tempContainer;
    }

}
