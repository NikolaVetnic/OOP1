package p07_izuzeci;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PWCatch {

	public static void main(String[] args) {
		
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter("res//PWCatch_Out.txt")));
			pw.println("Hello world!");
			System.out.println("Uspesan upis u fajl!");
		} catch (FileNotFoundException e) { 
			System.out.println("Greska prilikom kreiranja fajla");
		} catch (IOException e) {
			System.out.println("Greska prilikom pisanja u fajl");
		} finally {
			if (pw != null) pw.close();
		}
	}
}
