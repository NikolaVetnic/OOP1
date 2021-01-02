package p07_izuzeci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenerisanjeIzuzetaka {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(prvaLinija("res//engleski.txt"));
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja fajla");
		}
		
//		System.out.println(prvaDvaSlova1("m"));
		
		stampajPrvaDva2("m");
	}

	public static String prvaDvaSlova1(String rec) throws IllegalArgumentException {
		if (rec.length() < 2)
			throw new IllegalArgumentException("Rec nema dva slova");
		
		return rec.substring(0, 2);
	}
	
	public static String prvaDvaSlova2(String rec) throws KratakString {
		if (rec.length() < 2) throw new KratakString();
		return rec.substring(0, 2);
	}
	
	public static void stampajPrvaDva2(String str) {
		try {
			System.out.println(prvaDvaSlova2(str));
		} catch (KratakString ks) {
			System.out.println(ks.getMessage());
		}
	}
	
	public static String prvaLinija(String ulazniFajl) throws IOException {
		
		File f = new File(ulazniFajl);
		if (!f.exists())
			throw new IOException("Fajl ne postoji");
		if (!f.canRead())
			throw new IOException("Fajl ne moze da se cita");
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			return br.readLine();
		}
	}
}
