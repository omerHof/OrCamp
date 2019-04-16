import java.util.HashMap;

public abstract class Dictionary {

    protected HashMap<Character,Character> languageDictionary =new HashMap<>();

    public char convertletter(char c){
        if (languageDictionary.containsKey(c)){
            return languageDictionary.get(c);
        }
        System.out.println("char is not in the dictionary");
        char d= '!';
        return d;
    }

    public void printDic(){
        for (HashMap.Entry<Character,Character> entry : languageDictionary.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }
}


