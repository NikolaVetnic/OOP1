package pv02_z02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pv02_z02.Objava.Tema;

public class Forum {

	private Objava[] objave;
	
	// constructor
	private Forum(String inputFile) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new FileReader(inputFile));
		
		objave = new Objava[Integer.parseInt(br.readLine())];
		
		for (int i = 0; i < objave.length; i++) {
			
			String line = br.readLine();
			
			objave[i] = Objava.nova(
								    line.split(",")[0].trim(),
								    line.split(",")[1].trim(),
				   Integer.parseInt(line.split(",")[2].trim()));
		}
		
		br.close();
	}
	
	public static Forum ucitaj(String inputFile) throws IOException {
		return new Forum(inputFile);
	}
	
	// methods
	public Objava najpopularnijaObjava(String tema) {
		
		Objava n = null;
		
		if (!Objava.jeValidnaTema(tema)) {
			System.out.println("Tema nije validna.");
			return null;
		}
		
		for (Objava o : objave)
			if (o.tema().equalsIgnoreCase(tema))
				if (n == null || n.brojKomentara() < o.brojKomentara())
					n = o;
		
		if (n == null) {
			System.out.println("Objave u okviru zadate teme ne postoje.");
			return null;
		} else {
			return n;
		}
	}
	
	public void statistika() {
		
		Tema[] teme = Tema.values();
		
		int[] sumObj = new int[4];
		int[] sumKom = new int[4];
		
		for (Objava o : objave) {
			
			for (int i = 0; i < teme.length; i++)
				if (teme[i].tema().equalsIgnoreCase(o.tema())) {
					sumObj[i]++;
					sumKom[i] += o.brojKomentara();
				}
		}
		
		System.out.printf("%-15s %-13s %-15s\n", "TEMA", "BR. OBJ.", "BR. KOM.");
		for (int i = 0; i < teme.length; i++)
			System.out.printf("%-15s [objave: %3d] [komentari: %3d]\n", teme[i].tema(), sumObj[i], sumKom[i]);
	}
	
	// print
	public void stampaj() { for (Objava o : objave) System.out.println(o); }
}
