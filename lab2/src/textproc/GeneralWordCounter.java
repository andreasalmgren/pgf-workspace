package textproc;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.File;


public class GeneralWordCounter implements TextProcessor {
    private Map<String, Integer> wordmap = new HashMap<>();
    private Set<String> dontCount = new HashSet<>();
    private Map<String, Integer> result = new HashMap<>();

    public GeneralWordCounter(Set<String> set){
        this.dontCount = set;
    }
    public void process(String w) {
        int count = wordmap.getOrDefault(w, 0);
        if (!(dontCount.contains(w))) {
                wordmap.put(w, count + 1);
        }
    }

    public void report(){
    Set<Map.Entry<String, Integer>> wordSet = wordmap.entrySet();
    List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
    wordList.sort((p1, p2) -> p2.getValue() - p1.getValue());
    //wordList.sort((p1, p2) -> p2.getKey().compareTo((p1.getKey())));
    for(int i = 0; i < 5; i++){
        System.out.println(wordList.get(i));
        }
        System.out.println(result);
    }


}
