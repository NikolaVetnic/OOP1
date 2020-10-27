package tv02_z05;

import java.io.IOException;

public class Main {

	public static void main(String[] args) 
		throws IOException
	{
		Generacija g = Generacija.ucitaj("res//generacija.txt");
		
		g.nagrade("DMI");
		Student najbolji = g.najboljiNaDepartmanu("DMI");
		System.out.println("Najbolji student na DMI: " + najbolji);
	}
}
