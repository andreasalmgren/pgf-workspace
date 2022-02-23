package mountain;

public class Side {
	public Point p1;
	public Point p2;
	
	public Side(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
    @Override
    public int hashCode() {
    	return p1.hashCode() + p2.hashCode();
    }
    
    @Override
	public boolean equals(Object obj) {
		if (obj instanceof Side) {
			Side s = (Side)obj;
			return (p1.equals(s.p1) || p1.equals(s.p2)) && (p2.equals(s.p2) || p2.equals(s.p1));
		} else {
			return false;
		}
	}
}
