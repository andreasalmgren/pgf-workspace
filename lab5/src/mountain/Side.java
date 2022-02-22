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
    public boolean equals(Object s) {
    	Side side = (Side) s;
    	if(side.p1 == this.p1 && side.p2 == this.p2) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
