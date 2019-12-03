package Algorithms;

import java.util.HashMap;
import java.util.Objects;

/**
 * class for word - contain a string represents the word and a hashMap that contains all its subWords and number of appears
 *
 */

public class Word {


    private String word;
    private HashMap<Word,Integer> nextWord;

    public Word(String word) {
        String goodWord = "";
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int x = (int) word.charAt(i);
            if (i==0 && x==1493 ){
               continue;
            }
            if (x>1487 && x<1515 ){
                goodWord=goodWord+c;
            }
        }
        this.word = goodWord;
        this.nextWord = new HashMap<>();

    }

    public void setWord(String word) {
        this.word = word;
    }


    public String getWord() {
        return word;
    }

    public void setNextWord(HashMap<Word, Integer> nextWord) {
        this.nextWord = nextWord;
    }

    public HashMap<Word, Integer> getNextWord() {
        return nextWord;
    }

    @Override
    public String toString() {
        return word ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
