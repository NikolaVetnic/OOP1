package usmeni_ispit.qB26_izuzeci;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyTxtFile {

	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("Pokretanje: java CopyTxtFile Src Dst");
			return;
		}
		
		File src = new File(args[0]);
		if (!src.exists() || !src.canRead()) {
			System.out.println("Izvorni fajl ne postoji ili se ne moze citati");
			return;
		}
		
		try (BufferedReader br = new BufferedReader(
								 new FileReader(args[0]));
			 PrintWriter 	pw = new PrintWriter(
					 			 new BufferedWriter(
					 			 new FileWriter(args[1])));
		) {
			String line;
			while ((line = br.readLine()) != null)
				pw.println(line);
		} catch (IOException e) {
			System.out.println("Greska prilikom kopiranja");
		}
				
	}
}
