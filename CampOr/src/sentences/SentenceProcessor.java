package sentences;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class SentenceProcessor {

    TreeMap<String,String> sentences;


    public TreeMap<Object,Object> getData (String kid, String subject) throws FileNotFoundException {
        TreeMap<String,String> data = new TreeMap<>();


        InputStream is = SentenceProcessor.class.getResourceAsStream( "/kidsReports/" +kid+"/"+subject+".txt");



        String location = "kidsReports/" +kid+"/"+subject+".txt";
        try{

            BufferedReader buff = new BufferedReader(new InputStreamReader(is,StandardCharsets.UTF_8));
            //buff = new BufferedReader(new FileReader(location));
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

    private TreeMap<Object,Object> cutTheTree(TreeMap<String,String> sentence){
        TreeMap<Object, Object> output = new TreeMap<>();
        int i = 0;
        for (Map.Entry entry : sentence.descendingMap().entrySet()) {
            if (i++ < 6) {
                output.put(entry.getKey(),entry.getValue());
            }
        }
        return output;
    }

}


