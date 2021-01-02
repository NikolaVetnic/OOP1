package pv07_z01_p03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Glavna {

	public static void main(String[] args) {
		
		BufferedReader in = null;
		
		try {
			obradiAkciju(in);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.println("Nesto bas ne valja ovde...");
				}
			}
		}
	}

	private static void obradiAkciju(BufferedReader in) throws IOException {
		
		in = new BufferedReader(new FileReader("res//akcije.txt"));
		
		Uciteljica u = new Uciteljica();
		String linija;
		
		while ((linija = in.readLine()) != null)
			izvrsiAkciju(u, linija);
	}

	private static void izvrsiAkciju(Uciteljica u, String linija) {

		String[] tokens = linija.split(" ");
		
		if (tokens[0].trim().equals("roditeljski")) {
			u.odrziRoditeljski();
		} else if (tokens.length == 2 && tokens[0].trim().equals("pregledaj")) {
			u.pregledajZadatke("res//" + tokens[1].trim());
		} else {
			System.out.println("Nesto je poslo po zlu...");
		}
	}
}
