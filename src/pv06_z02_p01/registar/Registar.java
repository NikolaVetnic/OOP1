package pv06_z02_p01.registar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Registar {
	

	private Gazdinstvo[] gazdinstva;
	
	
	public Registar(String inGazdinstva, String inPolja) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("res//" + inGazdinstva + ".txt"));
		
		gazdinstva = new Gazdinstvo[Integer.parseInt(br.readLine().trim())];
		
		for (int i = 0; i < gazdinstva.length; i++) {
			String[] tokens = br.readLine().split(",");
			gazdinstva[i] = new Gazdinstvo(tokens[0].trim(), Integer.parseInt(tokens[1].trim()));
		}
		
		br.close();
		
		br = new BufferedReader(new FileReader("res//" + inPolja + ".txt"));
		
		int brPolja = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < brPolja; i++) {
			
			String[] tokens = br.readLine().split(",");
			
			String tip = tokens[0].trim();
			double povrsina = Double.parseDouble(tokens[1].trim());
			double ocekivaniPrinos = Double.parseDouble(tokens[2].trim());
			String ime = tokens[3].trim();
			
			Polje p = "kukuruz".equalsIgnoreCase(tip) ? new Gazdinstvo.PoljeKukuruza(povrsina, ocekivaniPrinos) :
														new Gazdinstvo.PoljePsenice (povrsina, ocekivaniPrinos) ;
			
			nadjiGazdinstvo(ime).dodajPolje(p);
		}
		
		br.close();
	}
	
	
	private Gazdinstvo nadjiGazdinstvo(String ime) {
		
		if (gazdinstva == null) {
			System.out.println("Nema ucitanih gazdinstava.");
			return null;
		}
		
		for (Gazdinstvo g : gazdinstva)
			if (ime.equals(g.ime()))
				return g;
		
		System.out.println("Trazeno gazdinstvo ne postoji.");
		return null;
	}
	
	
	public void stampaj() {
		for (Gazdinstvo g : gazdinstva) g.stampaj();
	}
	
	
	/** 
	 * Metod vraća ono gazdinstvo koje ima najveću potencijalnu zar
	 * adu na svim poljima gde se gaji prosleđeni usev.
	 * @param tipUseva može biti “psenica” ili “kukuruz”
	 */
	public Gazdinstvo najprofitabilnije(String tipUseva) {
		
		if (!"kukuruz".equalsIgnoreCase(tipUseva) && !"psenica".equalsIgnoreCase(tipUseva)) {
			System.out.println("Uneti tip useva ne postoji.");
			return null;
		}
		
		if (gazdinstva == null) {
			System.out.println("Nema ucitanih gazdinstava.");
			return null;
		}
		
		double maxK = -1.0, maxP = -1.0;
		Gazdinstvo gazdK = null, gazdP = null;
		
		for (Gazdinstvo g : gazdinstva) {
			
			double sumK = 0.0, sumP = 0.0; 
			
			for (int i = 0; i < g.brPolja(); i++) {
				if (g.polje(i) instanceof Gazdinstvo.PoljeKukuruza) sumK += g.polje(i).potencijalnaZarada();
				else												sumP += g.polje(i).potencijalnaZarada();
			}
			
			if (sumK > maxK) {
				maxK = sumK;
				gazdK = g;
			}
			
			if (sumP > maxP) {
				maxP = sumP;
				gazdP = g;
			}
		}
		
		if ("kukuruz".equalsIgnoreCase(tipUseva)) {
			System.out.printf("Najprofitabilnije gazdinstvo za tip useva '%s' je: '%s'\n", tipUseva, gazdK.ime());
			return gazdK;
		} else {
			System.out.printf("Najprofitabilnije gazdinstvo za tip useva '%s' je: '%s'\n", tipUseva, gazdP.ime());
			return gazdP;
		}
	}
	
	
	/**
	 * Vraća gazdinstvo koje će najmanje potrošiti na satnicu.
	 */	
	public Gazdinstvo najstedljivije() {
		
		if (gazdinstva == null) {
			System.out.println("Nema ucitanih gazdinstava.");
			return null;
		}
		
		double max = -1.0;
		Gazdinstvo out = null;
		
		for (Gazdinstvo g : gazdinstva) {
			int brojRadnika = 0;
			
			for (int i = 0; i < g.brPolja(); i++)
				brojRadnika += g.polje(i).brRadnika();
			
			double sum = brojRadnika * g.satnica();
			
			if (sum > max) {
				max = sum;
				out = g;
			}
		}
		
		System.out.println("Najstedljivije gazdinstvo je: " + out.ime());
		return out;
	}
}
