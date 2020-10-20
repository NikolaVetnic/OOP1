package tv01_z01;

public class Polygon {
	
	Point[] points;

	public Polygon(Point[] points) {
		this.points = points;
	}
	
	public double circumference() {
		
		double v = 0.0;
		
		for (int i = 0; i < points.length; i++)
			v += points[i].distanceTo(points[(i+1) % points.length]);
		
		return v;
	}
}
