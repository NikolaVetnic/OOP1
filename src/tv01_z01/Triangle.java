package tv01_z01;

public class Triangle extends Polygon {

	public Triangle(Point[] points) {
		super(points);
	}
	
	public Triangle(Point v1, Point v2, Point v3) {
		super(new Point[] { v1, v2, v3 });
	}
	
	public double circumference() {
		
		return this.points[0].distanceTo(points[1]) +
			   this.points[1].distanceTo(points[2]) +
			   this.points[2].distanceTo(points[0]) ;
	}
}
