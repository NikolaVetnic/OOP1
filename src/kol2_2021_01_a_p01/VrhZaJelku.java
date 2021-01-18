package kol2_2021_01_a_p01;

public class VrhZaJelku extends Ukras {

	
	private double visina;
	
	
	public VrhZaJelku(String boja, double tezina, double cena, double visina) {
		super(boja, tezina, visina);
		this.visina = visina;
	}
	
	
	public double visina()	{ return visina;	}
	
	
	public String inDetail() {
		return "[ boja: " + super.boja() + ", tezina: " + super.tezina() + 
			   ", cena: " + super.cena() + " RSD (visina : " + visina + ") ]";
	}
	
	@Override
	public String toString() {
		return super.toString() + " (visina vrha: " + visina + "cm)";
	}
}
