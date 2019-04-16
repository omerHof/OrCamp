import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class langConvert
{
    String word;
    hebrowDictionary hd;
    englishDictionary ed;

    public langConvert(String word) {
        this.word = word;
        hd = new hebrowDictionary();
        ed = new englishDictionary();
    }

    public String convert (){
        String res;
        langDetected tmp = new langDetected(word);
        if (tmp.isHebrow()){
            res= convertHebrowToEnglish(word);
        }else {
            res= convertEnglishToHebrow(word);
        }
        return res;

    }

    private String convertEnglishToHebrow(String word) {
        String res="";
        for (int i = 0; i <word.length() ; i++) {
            res = res+ed.convertletter(word.charAt(i));
        }
        return res;
    }

    private String convertHebrowToEnglish(String word) {

        String res="";
        for (int i = 0; i <word.length() ; i++) {
            res = res+hd.convertletter(word.charAt(i));
        }
        return res;
    }


}
