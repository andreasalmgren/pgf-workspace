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
	public static Set<String> stopwords;
	public static Scanner scan;

	static {
		try {
			scan = new Scanner(new File("undantagsord.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Holgersson() throws FileNotFoundException {
	}


	public static void main(String[] args) throws FileNotFoundException {
		stopwords = new HashSet<>();
		while(scan.hasNext()){
			stopwords.add(scan.next());
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
	}
}