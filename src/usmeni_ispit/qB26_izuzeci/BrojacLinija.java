package usmeni_ispit.qB26_izuzeci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BrojacLinija {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Koriscenje: java BrojacLinija ImeUlaznogFajla");
			return;
		}
		
		File f = new File(args[0]);
		if (!f.exists() || !f.canRead()) {
			System.out.println("Ulazni fajl ne postoji ili se ne moze citati");
			return;
		}
		
		int brojLinija = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			while (br.readLine() != null) brojLinija++;
			System.out.println("Broj linija = " + brojLinija);
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja fajla");
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom zatvaranja fajla");
			}
		}
	}
}
