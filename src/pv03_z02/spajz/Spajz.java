package pv03_z02.spajz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Spajz {

	Polica[] police;
	
	/**
	 * NAPOMENA: zadatak traži da jedan od parametara pri kreiranju po-
	 * lice bude i maksimalna težina, međutim tog podatka nema u fajlu.
	 * Iz tog razloga se u konstruktoru špajza maksimalna težina za ne-
	 * plastične police postavlja na 10.0.
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	
	private void postaviPolice(String fileP) throws NumberFormatException, IOException {

		BufferedReader brP = new BufferedReader(
				new FileReader(fileP));
		
		police = new Polica[Integer.parseInt(brP.readLine().trim())];
		
		for (int i = 0; i < police.length; i++) {
			
			String[] tokens = brP.readLine().split(",");
			
			if (tokens[0].length() > 5)
				police[i] = PlasticnaPolica.nova(tokens[0].trim(), Integer.parseInt(tokens[1].trim()));
			else
				police[i] = Polica.nova(tokens[0].trim(), Integer.parseInt(tokens[1].trim()), 10.0);
		}
		
		brP.close();
	}
	
	private void postaviTegle1(String fileT) throws NumberFormatException, IOException {
		
		/**
		 * NAPOMENA: ovo je moja ideja "cikličnog" dodavanja tegli - učit-
		 * am sve tegle u niz, na prvu policu dodajem koliko može, kada v-
		 * iše ne može nastavljam na sledećoj polici, a kada dođem do kra-
		 * ja niza tegli idem ponovo na početak.
		 */

		BufferedReader brT = new BufferedReader(
				new FileReader(fileT));
		
		int count = Integer.parseInt(brT.readLine().trim());
		Tegla[] temp = new Tegla[count];
		
		for (int i = 0; i < count; i++) {

			String[] tokens = brT.readLine().split(",");
			
			temp[i] = Tegla.nova(
					Double.parseDouble(tokens[0].trim()), 
					Double.parseDouble(tokens[1].trim()),
									   tokens[2].trim());
		}
		
		brT.close();
		
		int pos = 0;
		
		for (Polica p : police) {
			
			boolean popunjeno = false;
			
			while (!popunjeno) {
				popunjeno = !p.dodajTeglu(temp[pos]);
				pos = (pos + 1) % temp.length;
			}
		}
	}
	
	private void postaviTegle2(String fileT) throws NumberFormatException, IOException {
		
		/**
		 * NAPOMENA: ovo je ideja koju ste vi izneli u mailu jednom kolegi
		 * dok smo još radili zadatak - na prvu policu se stavlja prva te-
		 * gla, na drugu druga, na treću treća... Kada se dođe do kraja n-
		 * iza tegli, ponovo se prelazi na početak. 
		 */

		BufferedReader brT = new BufferedReader(
				new FileReader(fileT));
		
		int count = Integer.parseInt(brT.readLine().trim());
		Tegla[] temp = new Tegla[count];
		
		for (int i = 0; i < count; i++) {

			String[] tokens = brT.readLine().split(",");
			
			temp[i] = Tegla.nova(
					Double.parseDouble(tokens[0].trim()), 
					Double.parseDouble(tokens[1].trim()),
									   tokens[2].trim());
		}
		
		brT.close();
		
		int pos = 0;
		
		for (int j = 0; j < Polica.maxTegli(); j++) {
			for (int i = 0; i < police.length; i++) {
				police[i].dodajTeglu(temp[pos]);
				pos = (pos + 1) % temp.length;
			}
		}
	}
	
	private Spajz(String fileP, String fileT, int nacinSlaganja) throws NumberFormatException, IOException {
		
		postaviPolice(fileP);
		
		if (nacinSlaganja == 1) postaviTegle1(fileT);
		else 					postaviTegle2(fileT);
	}
	
	public static Spajz ucitaj(String inputP, String inputT, int nacinSlaganja) throws NumberFormatException, IOException {
		return new Spajz("res//" + inputP + ".txt", "res//" + inputT + ".txt", nacinSlaganja);
	}
	
	public double ukupnaTezina() {
		
		double sum = .0;
		
		for (Polica p : police)
			for (int i = 0; i < p.brTegli(); i++)
				sum += p.tegla(i).tezina();
		
		System.out.printf("Ukupna tezina zaliha za zimu : %.1f\n", sum);
		
		return sum;
	}
	
	public Polica najopterecenijaPlastika() {
		
		Polica out = null;
		
		for (Polica p : police)
			if (p instanceof PlasticnaPolica)
				if (out == null)
					out = p;
				else
					if (p.trenutnaTezina() > out.trenutnaTezina())
						out = p;
		
		System.out.println("Najopterecenija plasticna polica je:\n" + out);
		
		return out;
	}
	
	public void print() {
		
		for (Polica p : police) {
			System.out.print(p);
			
			for (int i = 0; i < p.brTegli(); i++) {
				
				System.out.println("\tTegla #" + i + " : " + p.tegla(i));
			}
			
			System.out.println();
		}
	}	
}