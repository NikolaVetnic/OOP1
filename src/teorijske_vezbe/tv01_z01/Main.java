package teorijske_vezbe.tv01_z01;

public class Main {
	
	public static void main(String[] args) {
		
		Point[] verts1 = {
				new Point(0, 0),
				new Point(3, 0),
				new Point(0, 4)
		};
		
		Point[] verts2 = {
				new Point(0, 0),
				new Point(0, 1),
				new Point(1, 0)
		};
		
		Polygon p1 = new Polygon(verts1);
		Polygon p2 = new Polygon(verts2);
		
		if (p1.circumference() > p2.circumference())
			System.out.println("Obim prvog trougla je veci.");
		else if (p1.circumference() == p2.circumference())
			System.out.println("Obimi su jednaki.");
		else
			System.out.println("Obim drugog trougla je veci.");

		Triangle t1 = new Triangle(new Point(0, 0), new Point( 3, 0), new Point(0,  4));
		Triangle t2 = new Triangle(new Point(0, 0), new Point(-1, 0), new Point(0, -1));
		
		if (t1.circumference() > t2.circumference())
			System.out.println("Obim prvog trougla je veci.");
		else if (t1.circumference() == t2.circumference())
			System.out.println("Obimi su jednaki.");
		else
			System.out.println("Obim drugog trougla je veci.");
	}
}
