package kol1_2020_11_b_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Prodavnica implements Servis {

	private Uredjaj[] uredjaji;
	private Uredjaj[] zaServis;
	
	int brUredjajaZaPopravku;
	
	public Prodavnica() throws IOException {
		zaServis = new Uredjaj[3];
		ucitajUredjaje();
	}

	private void ucitajUredjaje() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/uredjaji.txt"));
		int brUredjaja = Integer.parseInt(in.readLine().trim());
		brUredjajaZaPopravku = 0;
		
		uredjaji = new Uredjaj[brUredjaja];
		
		for (int i = 0; i < brUredjaja; i++) {
			String tokeni[] = in.readLine().split(",");
			String nazivUredjaja = tokeni[0].trim();
			String boja = tokeni[1].trim();
			double jacinaProcesora = Double.parseDouble(tokeni[2].trim());
			int ramMemorija = Integer.parseInt(tokeni[3].trim());
			double cena = Double.parseDouble(tokeni[4].trim());
			
			switch (nazivUredjaja) {
				case "laptop":
					boolean imaKameru = tokeni[5].equals("da");
					uredjaji[i] = new Laptop(boja, jacinaProcesora, ramMemorija, cena, imaKameru);
					break;
				case "desktop":
					uredjaji[i] = new DesktopRacunar(boja, jacinaProcesora, ramMemorija, cena);
					break;
				case "telefon":
					uredjaji[i] = new Telefon(boja, jacinaProcesora, ramMemorija, cena);
					break;
				default:
					System.out.println("Pogresan unos uredjaja !");
					break;
 			}
			
		}
		
		in.close();
	}
	
	public double prodaj() {
		double vrednost = 0.0;
//		int brUredjajaZaPopravku = 0;
		
		for (int i = 0; i < uredjaji.length; i++) {
			if (uredjaji[i].jePotrebanServis()) {
				System.out.println("SERVIS ZA " + uredjaji[i]);
				if (brUredjajaZaPopravku < 3)
					zaServis[brUredjajaZaPopravku++] = uredjaji[i];
			} else {
				System.out.println("PRODAJEMO: " + uredjaji[i]);
				vrednost += uredjaji[i].getCena();
			}
		}
		
		for (int i = 0; i < brUredjajaZaPopravku; i++)
			System.out.println("\t Popravka za: " + zaServis[i]);
		
		System.out.println("Broj za popravku: " + brUredjajaZaPopravku);
		
		return vrednost;
	}

	@Override
	public boolean popravi() {
		boolean popravljen = true;
		
		if (zaServis != null) {
			
			Random rnd = new Random();
			
			for (Uredjaj uredjaj : zaServis) {
				int procenat = rnd.nextInt(100);
				
				if (uredjaj instanceof Telefon) {
					// >= zato sto nextInt(100) daje rez od 0 do 99 ---> 0,1,2,..,99 
					// pa pre broja 80 moze da ima ukupno 80 vrednost, tj. 0,1,2,...,79
					if (procenat >= 80) 
						popravljen = false;
				} else {
					if (procenat >= 75)
						popravljen = false;
				}
			}
			
		}
		
		return popravljen;
	}
	
	@Override 
	public String toString() {
		String rez = "";
		
		rez += "Svi uredjaji: \n";
		for (Uredjaj uredjaj : uredjaji) {
			if (uredjaj != null)
				rez += uredjaj + "\n";
		}
		
		rez += "Uredjaji za popravku: \n";
		for (Uredjaj uredjaj : zaServis) {
			if (uredjaj != null)
				rez += uredjaj + "\n";
		}
		
		return rez;
	}
	
}
