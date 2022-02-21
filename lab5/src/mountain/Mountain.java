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
        turtle.moveTo(turtle.getWidth() / 2.0 - a.getX() / 2.0,
                turtle.getHeight() / 2.0 + Math.sqrt(3.0) * a.getY() / 4.0);
        fractalLine(turtle, order, a, b, c ,0);
        //fractalLine(turtle, order,length,0);
        //fractalLine(turtle, order,length,120);
        //fractalLine(turtle, order,length,240);


        /*
        turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0,
                turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
        fractalLine(turtle, order,length,0);
        fractalLine(turtle, order,length,120);
        fractalLine(turtle, order,length,240);
         */
    }

    /*
     * Reursive method: Draws a recursive line of the triangle.
     */
    private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, int alpha) {
        if (order == 0) {
            turtle.penDown();
            turtle.setDirection(alpha);
            turtle.forwardTo(b.getX(), b.getY());
            turtle.forwardTo(c.getX(), c.getY());
            turtle.forwardTo(turtle.getWidth() / 2.0 - a.getX() / 2.0, turtle.getHeight() / 2.0 + Math.sqrt(3.0) * a.getY() / 4.0);
        } else {
            // fractalLine(turtle, order-1, ); beräkna sidlängd för att avgöra var vi ska börja rita???
        }
        /*
        if (order == 0) {
            //"rita en linje med längden length och riktningen alpha"
            turtle.penDown();
            turtle.setDirection(alpha);
            turtle.forward(length);
        } else {
            fractalLine(turtle, order-1, length/3, alpha);
            fractalLine(turtle,order-1, length/3, alpha-60);
            fractalLine(turtle,order-1, length/3, alpha+60);
            fractalLine(turtle,order-1, length/3, alpha);
        }

         */
    }
}
