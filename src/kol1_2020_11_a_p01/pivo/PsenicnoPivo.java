package kol1_2020_11_a_p01.pivo;

import kol1_2020_11_a_p01.Osobina;

public class PsenicnoPivo extends Pivo {
	
	public boolean pitko;
	
	public PsenicnoPivo(String proizvodjac) {
		
		super();
		
		this.setProizvodjac(proizvodjac);
		this.setJacina(Osobina.rng.nextDouble() + 5.0);
		this.setBoja(Osobina.BOJA[Osobina.rng.nextInt(2)]);
		this.setTip("psenicno");
		this.pitko = !this.jeIzlapelo();
	}
	
	@Override
	public String toString() {
		return super.toString() + (pitko ? "pitko" : "izlapelo");
	}

	@Override
	boolean jeIzlapelo() {
		return Osobina.rng.nextDouble() < 0.1;
	}
}
