package usmeni_ispit.qB26_izuzeci;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PWResources {

	public static void main(String[] args) {
		
		try (PrintWriter pw = new PrintWriter(
							  new BufferedWriter(
							  new FileWriter("res//p07_izuzeci-PWResources.txt")))) {
			pw.println("Hello world!");
		} catch (IOException e) {
			System.out.println("Greska prilikom pisanja u fajl");
		}
	}
}
