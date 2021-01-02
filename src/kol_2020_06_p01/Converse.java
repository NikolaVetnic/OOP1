package kol_2020_06_p01;

public class Converse extends Nike {

	public Converse(int broj) {
		super(broj);
		
		this.setCena	(this.cena() * 1.1);
		this.setBoja	(Osobina.BOJA[Patike.rng.nextInt(5)]);
		this.setMarka	("Converse");
	}

}
