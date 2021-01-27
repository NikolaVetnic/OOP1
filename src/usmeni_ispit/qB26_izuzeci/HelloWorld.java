package usmeni_ispit.qB26_izuzeci;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld {

	public static void main(String[] args) {
		
		try {
			pisi("res//p07_izuzeci-HelloWorld.txt");
		} catch (IOException e) {
			System.out.println("Greska prilikom pisanja u fajl");
		}
	}
	
	private static void pisi(String outFileName) throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFileName)));
		pw.println("Hello world!");
		pw.close();
	}
}
