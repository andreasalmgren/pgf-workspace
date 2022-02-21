package mountain;

import fractal.*;

public class Mountain extends Fractal {

    private Point a;
    private Point b;
    private Point c;

    /** Creates an object that handles Koch's fractal.
     * @param length the length of the triangle side
     */
    public Mountain(Point a, Point b, Point c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns the title.
     * @return the title
     */
    @Override
    public String getTitle() {
        return "Bergfraktal";
    }

    /** Draws the fractal.
     * @param turtle the turtle graphic object
     */
    @Override
    public void draw(TurtleGraphics turtle) {
        fractalTriangle(turtle, order, a, b, c);
    }

    private Point calcPoint (Point a, Point b){

        // Calculate center between two X-points
        int x = a.getX() + (b.getX() - a.getX()) / 2;

        // Center between Y:s, and adding an offset
        int y = a.getY() + (b.getY() - a.getY()) / 2;

        return new Point(x, y);
    }

    /*
     * Reursive method: Draws a recursive line of the triangle.
     */
    private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
        if (order == 0) {
            turtle.moveTo(a.getX(), a.getY());

            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());

            turtle.forwardTo(a.getX(), a.getY());

            // Middle of the two points
            Point ab = calcPoint(a, b);
            Point ac = calcPoint(a, c);
            Point bc = calcPoint(b, c);

            // Points for the new triangles
            Point[][] triangles = new Point[][]{{a, ab, ac}, {ab, b, bc}, {ac, bc, c}, {bc, ac, ab}};

            // Draw all triangles
            for (Point[] p : triangles) {
                fractalTriangle(turtle, order - 1, p[0], p[1], p[2]);
            }
        }
    }
}
