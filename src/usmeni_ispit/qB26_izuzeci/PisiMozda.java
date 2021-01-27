package usmeni_ispit.qB26_izuzeci;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PisiMozda {

	public static void main(String[] args) {
		
		pisiMozda();
	}
	
	public static void pisiMozda() {
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("res//p07_izuzeci-pisiMozda.txt")));
			
			if (Math.random() < 0.5)
				return;			// izvrsava se finally blok
			
			pw.println("Hello world!");
			System.out.println("Uspesno!");
		} catch (IOException e) {
			System.out.println("Greska");
		} finally {
			if (pw != null) pw.close();
		}
	}
}
