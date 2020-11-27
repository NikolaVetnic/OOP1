package kol1_2020_11_a_p01.kafana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import kol1_2020_11_a_p01.Osobina;
import kol1_2020_11_a_p01.pivo.CrvenoPivo;
import kol1_2020_11_a_p01.pivo.KraftPivo;
import kol1_2020_11_a_p01.pivo.Pivo;
import kol1_2020_11_a_p01.pivo.PsenicnoPivo;

public class Kafana implements Sanker {
	
	private String ime, adresa;
	
	private Pivo[] piva;
	private int ukupnoPosluzenihPiva;
	
	public Kafana(String ime, String adresa, String input) throws IOException {
		
		this.ime = ime;
		this.adresa = adresa;
		
		String file = "res//" + input + ".txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		piva = new Pivo[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < piva.length; i++) {
			
			String[] tokens = br.readLine().split(";");
			
			String proizvodjac = tokens[0].trim();
			String tip = tokens[1].trim();
			
			if (tip.equals(Osobina.TIP[0])) 
				piva[i] = new PsenicnoPivo(proizvodjac);
			else if (tip.equals(Osobina.TIP[1])) 
				piva[i] = new KraftPivo(proizvodjac);
			else 
				piva[i] = new CrvenoPivo(proizvodjac);
		}
		
		this.ukupnoPosluzenihPiva = 0;
		
		br.close();
	}
	
	public void print() {
		
		System.out.println(ime + ", " + adresa);
		
		for (Pivo p : piva)
			System.out.println("\t" + p);
		
		System.out.println("Ukupna kolicina piva (kom): " + (piva.length - ukupnoPosluzenihPiva));
		System.out.println();
	}
	
	public String toString() {
		return String.format("%s, %s (ukupna kolicina piva: %d)", ime, adresa, piva.length - ukupnoPosluzenihPiva);
	}

	@Override
	public void posluziPivo() {
		
		Arrays.sort(piva);
		
		int posluzenihSada = 0;
		
		System.out.println("Sluzimo pivo!");
		
		for (Pivo p : piva) {
			
			if (p instanceof PsenicnoPivo) { 
				PsenicnoPivo tmp = (PsenicnoPivo) p;
				if (tmp.pitko) {
					System.out.println("\tSada sluzim: " + p);
					posluzenihSada++;
				}
			} else if (p instanceof KraftPivo) {
				KraftPivo tmp = (KraftPivo) p;
				if (tmp.pitko) {
					System.out.println("\tSada sluzim: " + p);
					posluzenihSada++;
				}
			} else {
				CrvenoPivo tmp = (CrvenoPivo) p;
				if (tmp.pitko) {
					System.out.println("\tSada sluzim: " + p);
					posluzenihSada++;
				}
			}
		}
		
		ukupnoPosluzenihPiva += posluzenihSada;
		
		System.out.printf("Sada sam posluzio %d piva, a ukupno je posluzeno %d piva.\n", 
				posluzenihSada, ukupnoPosluzenihPiva);
		System.out.println();
	}

	public String ime() 				{ return ime; 					}
	public String sdresa() 				{ return adresa; 				}
	public Pivo[] piva() 				{ return piva; 					}
	public Pivo pivo(int i)				{ return piva[i];				}
	public int ukupnoPosluzenihPiva() 	{ return ukupnoPosluzenihPiva; 	}
	
	public double prosecnaJacinaPiva() {
		
		double sum = 0.0;
		for (Pivo p : piva) sum += p.jacina();
		
		System.out.printf("Prosecna jacina piva u kafani: %4.2f", sum / piva.length);
		
		return sum / piva.length;
	}
}
