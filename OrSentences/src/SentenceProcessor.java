import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class SentenceProcessor {

    TreeMap<String,String> sentences;


    public TreeMap<Object,Object> getData (String kid, String subject){
        TreeMap<String,String> data = new TreeMap<>();
        BufferedReader buff;
        String location = kid+"/"+subject+".txt";
        try{
            buff = new BufferedReader(new FileReader(location));
            String key = buff.readLine();
            while(key!=null){
                String value= buff.readLine();
                data.put(key,value);
                key = buff.readLine();
            }
            buff.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cutTheTree(data);
    }

    public TreeMap<Object,Object> cutTheTree(TreeMap<String,String> sentence){
        TreeMap<Object, Object> output = new TreeMap<>();
        int i = 0;
        for (Map.Entry entry : sentence.descendingMap().entrySet()) {
            if (i++ < 3) {
                output.put(entry.getKey(),entry.getValue());
            }
        }
        return output;
    }

}


