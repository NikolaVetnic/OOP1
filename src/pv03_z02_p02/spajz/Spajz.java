package pv03_z02_p02.spajz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Spajz {
	

	private Polica[] police;
	
	
	private void postaviPolice(String inPolice) throws NumberFormatException, IOException {
		
		String fileP = "res//" + inPolice + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(fileP));
		
		police = new Polica[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < police.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			String proizv = tokens[0].trim();
			int brjRed = Integer.parseInt(tokens[1].trim());
			
			if (Polica.materijal(proizv).equals("plastika"))
				police[i] = new PlasticnaPolica(proizv, brjRed);
			else
				police[i] = new Polica(proizv, brjRed, Polica.DEFAULT_MAXOPT);
		}
		
		br.close();
	}
	
	
	private void postaviTegle(String inTegle) throws IOException {
		
		String fileT = "res//" + inTegle + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(fileT));
		
		Tegla[] inputArr = new Tegla[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < inputArr.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			double zap = Double.parseDouble(tokens[0].trim());
			double tez = Double.parseDouble(tokens[1].trim());
			String sad = 					tokens[2].trim() ;
			
			inputArr[i] = new Tegla(zap, tez, sad);
		}
		
		int count = 0;
		
		for (Polica p : police)
			while (p.moguDaDodam(inputArr[count % inputArr.length]))
				p.dodajTeglu(inputArr[count++ % inputArr.length]);
		
		br.close();
	}
	
	private Spajz(String inPolice, String inTegle) throws NumberFormatException, IOException {
		
		postaviPolice(inPolice);
		postaviTegle(inTegle);
	}
	
	public static Spajz ucitaj(String inPolice, String inTegle) throws NumberFormatException, IOException {
		return new Spajz(inPolice, inTegle);
	}
	
	
	public void print() {
		
		for (Polica p : police) {
			System.out.print(p);
			
			for (int i = 0; i < p.brjTgl(); i++)
				System.out.println("\tTegla #" + i + " : " + p.tegla(i));
			
			System.out.println();
		}
	}	
	
	
	public double ukupnaTezina() {
		
		double sum = 0.0;
		
		for (Polica p : police)
			for (Tegla t : p.tegle)
				sum += t.tez();
		
		System.out.printf("Ukupna tezina zaliha za zimu: %-6.2f", sum);
		
		return sum;
	}
	
	
	public Polica najopterecenijaPlastika(double max) {
		
		Polica out = null;
		
		for (Polica p : police)
			if (p instanceof PlasticnaPolica && p.trnOpt() < max)
				if (out == null)
					out = p;
				else
					if (p.trnOpt() > out.trnOpt())
						out = p;
		
		if (out != null)
			System.out.println("Najopterecenija plastika: " + out);
		else
			System.out.printf("Nema plasticnih polica ili su sve opterecenja veceg od %.1fkg.\n", max);
		
		return out;
	}
}