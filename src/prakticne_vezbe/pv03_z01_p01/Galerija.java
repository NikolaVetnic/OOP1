package prakticne_vezbe.pv03_z01_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Galerija {
	

	private Umetnik[] umetnici;
	
	
	public Galerija(String inUmetnici, String inDela) throws IOException {
		
		String file = "res//" + inUmetnici + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		umetnici = new Umetnik[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < umetnici.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			if (tokens.length == 1)
				umetnici[i] = new Slikar(tokens[0].trim());
			else
				umetnici[i] = new Umetnik(
										 tokens[0].trim(), 
						Integer.parseInt(tokens[1].trim()));
		}
		
		ucitajDela(inDela);
		
		br.close();
	}

	
	private Umetnik nadjiUmetnika(String ime) {
		
		if (umetnici == null) return null;
		
		for (Umetnik u : umetnici) 
			if (u.ime().equals(ime)) return u;
		
		return null;
	}
	
	
	private void ucitajDela(String input) throws IOException {
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		int numDela = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < numDela; i++) {
			
			String ime = br.readLine().trim();
			Umetnik u = nadjiUmetnika(ime);
			
			if (u == null) continue;
			
			u.izlozi(new UmetnickoDelo(
					br.readLine().trim(),
					Integer.parseInt(br.readLine().trim()),
					Double.parseDouble(br.readLine().trim())
					));
		}
		
		br.close();
	}
	
	
	public void print() { for (Umetnik u : umetnici) u.print(); }
	
	
	public Slikar autorNajstarijegDela() {
		
		Slikar out = null;
		
		for (Umetnik u : umetnici)
			if (u instanceof Slikar)
				if (out == null)
					out = (Slikar) u;
				else
					if (u.godNajstarijeg() < out.godNajstarijeg())
						out = (Slikar) u;
		
		System.out.println("Slikar sa najstarijim delom je: " + out.ime());
		
		return out;
	}
	
	
	public void prosecnaVrednostSvihDela() {
		
		double sum = 0.0;
		int count = 0;
		
		for (Umetnik u : umetnici)
			for (UmetnickoDelo d : u.dela())
				if (d != null) {
					sum += d.cena();
					count++;
				}
		
		System.out.printf("Prosecna vrednost svih dela u galeriji: %.2f\n", sum / count);
	}
}
