package teorijske_vezbe.tv01_z02;

import java.util.Scanner;

import teorijske_vezbe.tv01_z01.Point;
import teorijske_vezbe.tv01_z01.Polygon;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Unesite dimenziju poligona: ");
		int n = sc.nextInt();
		
		Point[] verts = new Point[n];
		for (int i = 0; i < n; i++) {
			
			System.out.print(String.format("Tacka[%d], x = ", i));
			double x = sc.nextDouble();
			System.out.print(String.format("Tacka[%d], y = ", i));
			double y = sc.nextDouble();
			
			verts[i] = new Point(x, y);
		}
		
		Polygon p = new Polygon(verts);
		
		System.out.println("Obim: " + p.circumference());
		
		sc.close();
	}
}
