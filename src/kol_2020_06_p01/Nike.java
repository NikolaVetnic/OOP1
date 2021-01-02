package kol_2020_06_p01;

public class Nike extends Patike {
	
	
	public Nike(int broj) {

		super("", "", "", 0.0, broj, "");
		
		this.setTip		(Patike.rng.nextDouble() < 0.7 ? Osobina.TIP[0]   : Osobina.TIP[1]  );
		this.setVrsta	(Patike.rng.nextDouble() < 0.5 ? Osobina.VRSTA[0] : Osobina.VRSTA[1]);
		this.setBoja	(Osobina.BOJA[Patike.rng.nextInt(3)]);
		this.setCena	(this.tip().equals(Osobina.VRSTA[0]) ? 
												Patike.rng.nextDouble() * 500.0 + 2000.0   : 
												Patike.rng.nextDouble() * 5000.0 + 7000.0) ;
		this.setMarka	("Nike");
	}
}
