package textproc;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Holgersson {
	public static List<TextProcessor> txtproc = new ArrayList<>();
	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };
	public static Set<String> stopwords = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		System.out.println(new File(".").getAbsolutePath());
		Scanner t = new Scanner(new File("undantagsord.txt"));
		while(t.hasNext()){
			stopwords.add(t.next());
		}

		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor q = new SingleWordCounter("norge");
		TextProcessor r = new GeneralWordCounter(stopwords);

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			p.process(word);
			q.process(word);
			r.process(word);
		}

		s.close();
		p.report();
		q.report();
		r.report();
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
		//~ 350 ms
	}
}