package kol1_2020_11_b_p01;

import java.util.Random;

public class Laptop extends Uredjaj {

	public Laptop(String boja, double jacinaProcesora, int ramMemorija, double cena, boolean imaKameru) {
		super(boja, jacinaProcesora, ramMemorija, cena, imaKameru);
	}

	@Override
	public boolean jePotrebanServis() {
		String[] komponente = {"procesor", "maticna ploca", "ram"};
		
		Random rnd = new Random();
		
		int procenat = rnd.nextInt(100);
		if (procenat < 5) {
			
			int randomKomponenta = rnd.nextInt(3);
			
			System.out.println(komponente[randomKomponenta] + " je pokvaren(a), potreban je servis !");
			return true;
		}
		
		return false;
	}

}
