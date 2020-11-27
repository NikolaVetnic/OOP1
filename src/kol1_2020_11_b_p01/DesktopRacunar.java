package kol1_2020_11_b_p01;

import java.util.Random;

public class DesktopRacunar extends Uredjaj {

	public DesktopRacunar(String boja, double jacinaProcesora, int ramMemorija, double cena) {
		super(boja, jacinaProcesora, ramMemorija, cena, false);
	}

	@Override
	public boolean jePotrebanServis() {
		String[] komponente = {"procesor", "maticna ploca", "ram"};
		
		Random rnd = new Random();
		
		int procenat = rnd.nextInt(100);
		if (procenat < 3) {
			
			int randomKomponenta = rnd.nextInt(3);
			
			System.out.println(komponente[randomKomponenta] + " je pokvaren(a), potreban je servis ! ");
			return true;
			
		}
		
		return false;
	}

}
