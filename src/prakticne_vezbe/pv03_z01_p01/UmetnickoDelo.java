package prakticne_vezbe.pv03_z01_p01;

public class UmetnickoDelo {

	private final String naziv;
	private final int god;
	private double cena;
	
	public UmetnickoDelo(String naziv, int god, double cena) {
		this.naziv = naziv;
		this.god = god;
		this.cena = cena;
	}
	
	public String toString() {
		return String.format("'%s' (%d), cena : %.2f", naziv, god, cena);
	}

	public String naziv() 	{ return naziv; }
	public int god() 		{ return god; 	}
	public double cena() 	{ return cena; 	}
}
