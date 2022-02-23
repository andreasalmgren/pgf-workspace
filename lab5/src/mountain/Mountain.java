package mountain;

import fractal.*;
import java.util.HashMap;
import java.util.Map;

import static mountain.RandomUtilities.randFunc;

public class Mountain extends Fractal {
    private Point a;
    private Point b;
    private Point c;
    private double deviation;
    private Map<Side, Point> center = new HashMap<Side, Point>();

    /** Creates an object that handles Koch's fractal.
     * @param length the length of the triangle side
     */
    
    
    public Mountain(Point a, Point b, Point c, double deviation) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.deviation = deviation;
        center.put(new Side(a,b), calcPoint(a, b, randFunc(deviation)));
        center.put(new Side(a,c), calcPoint(a, c, randFunc(deviation)));
        center.put(new Side(b,c), calcPoint(b, c, randFunc(deviation)));
    }

    /**
     * Returns the title.
     * @return the title
     */
    @Override
    public String getTitle() { return "Bergfraktal"; }

    /**
     * Calculates the middle of two points
     * @param t     Point t
     * @param s     Point s
     * @return      the calculated point
     */
    private Point calcPoint (Point t, Point s, double random){
    	if(center.containsKey(new Side(t, s))) {
            //System.out.println("i");
    		return center.get(new Side(t, s));
    	}
    	else {
        // Calculate center between two X-points
        int x = t.getX() + (s.getX() - t.getX()) / 2;
        // Center between Y:s, and adding an offset
        int y = (int) (t.getY() + (s.getY() - t.getY()) / 2 + random);
        
        center.put(new Side(t, s), new Point(x, y));
        return new Point(x, y);
    	}
    }

    /** Draws the fractal.
     * @param turtle    the turtle graphic object
     */
    @Override
    public void draw(TurtleGraphics turtle) {
        fractalTriangle(turtle, order, deviation, a, b, c);
    }

    /*
     * Recursive method: Draws a recursive line of the triangle.
     */
    private void fractalTriangle(TurtleGraphics turtle, int order, double deviation, Point a, Point b, Point c) {
        if (order == 0) {
            turtle.moveTo(   a.getX(), a.getY());
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(a.getX(), a.getY());
            return;
        }

        // Middle of the two points
        Point ab = calcPoint(a, b, randFunc(deviation));
        Point ac = calcPoint(a, c, randFunc(deviation));
        Point bc = calcPoint(b, c, randFunc(deviation));

        // Points for the new triangles
        Point[][] triangles = new Point[][]{{a, ab, ac}, {ab, b, bc}, {ac, bc, c}, {bc, ac, ab}};

        // Draw all triangles
        for (Point[] p : triangles) {
            fractalTriangle(turtle, order - 1, deviation/2, p[0], p[1], p[2]);
        }
    }
}
