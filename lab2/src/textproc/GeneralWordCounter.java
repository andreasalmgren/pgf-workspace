package textproc;
import java.util.*;


public class GeneralWordCounter implements TextProcessor {
    private Map<String, Integer> wordmap = new HashMap<>();
    //private Map<String, Integer> wordmap = new TreeMap<>();
    private Set<String> dontCount = new HashSet<>();
    private Map<String, Integer> result = new HashMap<>();
    //private Map<String, Integer> result = new TreeMap<>();

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

    wordList.sort((p1, p2) -> {
        if(p2.getValue().equals(p1.getValue())) {return p1.getKey().compareTo(p2.getKey());}
        else {return p2.getValue() - p1.getValue();}
    });

    for(int i = 0; i < 5; i++){
        System.out.println(wordList.get(i));
        }
    }


}
