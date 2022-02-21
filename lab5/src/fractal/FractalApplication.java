package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Mountain(new Point(100, 300),
				new Point(400, 200),
				new Point(550, 420),
				15);
		fractals[1] = new Koch(300);	
		new FractalView(fractals, "Fraktaler", 600, 600);
	}
}