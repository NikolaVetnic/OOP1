package pv04_z01_p01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stovariste {

	private PolovnoVozilo[] vozila;
	
	public Stovariste(String ulazniFajl) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new FileReader(ulazniFajl));
		
		int brVozila = Integer.parseInt(br.readLine().trim());
		vozila = new PolovnoVozilo[brVozila];
		
		for (int i = 0; i < vozila.length; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			String tip 	= tokens[0].trim();
			int starost = Integer.parseInt(tokens[1].trim());
			int k 		= Integer.parseInt(tokens[2].trim());
			
			if (tip.compareTo("auto") == 0)
				vozila[i] = new PolovniAuto(starost, k);
			else
				vozila[i] = new PolovniKombi(starost, k);
		}
		
		br.close();
	}

	public PolovniKombi[] najjeftinijiKombi() {
		
		PolovniKombi najjeftiniji = null;
		int brojac = 0;
		
		for (int i = 0; i < vozila.length; i++) {
			if (vozila[i] instanceof PolovniKombi) {
				
				PolovniKombi pk = (PolovniKombi) vozila[i];
				
				if (najjeftiniji == null) {
					najjeftiniji = pk;
					brojac = 1;
				} else if (pk.cena() == najjeftiniji.cena()) {
					brojac++;
				} else if (pk.cena() <  najjeftiniji.cena()) {
					najjeftiniji = pk;
					brojac = 1;
				}
			}
		}
		
		
		if (brojac == 0) {
			return null;
		} else if (brojac == 1) {
			return new PolovniKombi[] { najjeftiniji };
		} else {
			PolovniKombi[] out = new PolovniKombi[brojac];
			int j = 0;
			
			for (int i = 0; i < vozila.length; i++)
				if (vozila[i] instanceof PolovniKombi && vozila[i].cena() == najjeftiniji.cena())
					out[j++] = (PolovniKombi) vozila[i];
			
			return out;
		}
	}
}
