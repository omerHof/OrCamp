import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class langDetected {

    String word;
    boolean hebrow;

    public langDetected(String word) {
        hebrow = this.hebrowDetected(word);
        this.word = word;
    }

    public boolean hebrowDetected (String word){
        Pattern p = Pattern.compile("\\p{InHebrew}", Pattern.UNICODE_CASE);
        Matcher m = null;

        boolean hebrewDetected = false;
        for (int i = 0; i < word.length() && !hebrewDetected; i++){
            String letter = word.charAt(i) + "";
            m = p.matcher(letter);
            hebrewDetected = m.matches();
            if (hebrewDetected){
                break;
            }
        }
        return hebrewDetected;
    }

    public String getWord() {
        return word;
    }

    public boolean isHebrow() {
        return hebrow;
    }
}
