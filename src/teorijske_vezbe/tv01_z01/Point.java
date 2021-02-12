package teorijske_vezbe.tv01_z01;

public class Point {
	
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(double x) {
		this(x, x);
	}
	
	public Point() {
		this(1.0, 1.0);
	}
	
	public double distanceTo(Point that) {
		return Math.sqrt(
				(this.x - that.x) * (this.x - that.x) + 
				(this.y - that.y) * (this.y - that.y));
	}

	public String toString() {
		return String.format("(%.2f , %.2f)", this.x, this.y);
	}
}
