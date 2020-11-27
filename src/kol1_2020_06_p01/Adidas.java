package kol1_2020_06_p01;

public class Adidas extends Patike {

	
	public Adidas(int broj) {

		super("", "", "", 0.0, broj, "");
		
		this.setTip		(Patike.rng.nextDouble() < 0.6 ? Patike.TIP[0]   : Patike.TIP[1]  );
		this.setVrsta	(Patike.rng.nextDouble() < 0.5 ? Patike.VRSTA[0] : Patike.VRSTA[1]);
		this.setBoja	(Patike.BOJA[Patike.rng.nextInt(3)]);
		this.setCena	(this.tip().equals(Patike.VRSTA[0]) ? 
												Patike.rng.nextDouble() * 500.0 + 2000.0   : 
												Patike.rng.nextDouble() * 5000.0 + 7000.0) ;
		this.setMarka	("Adidas");
	}
}
