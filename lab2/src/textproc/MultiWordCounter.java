package textproc;
import java.util.*;

public class MultiWordCounter implements TextProcessor {
    private Map<String, Integer> wordmap = new HashMap<>();


    public MultiWordCounter(String[] words){
        for(String s : words){
            wordmap.put(s, 0);
        }
    }

    public void process(String w) {
        int count = wordmap.getOrDefault(w, 0);
        if(wordmap.containsKey(w)){
            wordmap.put(w, count + 1);
        }
    }

    public void report() {
        System.out.println(wordmap.toString());
    }
}
