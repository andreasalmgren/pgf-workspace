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
        for (var entry : wordmap.entrySet()) {
            if(entry.getValue() >= 200){
                result.put(entry.getKey(), entry.getValue());
        }
        }
        System.out.println(result);
    }


}
