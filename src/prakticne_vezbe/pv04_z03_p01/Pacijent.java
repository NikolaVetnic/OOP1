package prakticne_vezbe.pv04_z03_p01;

public class Pacijent {

	private String ime, prz;
	private int god;
	
	public Pacijent(String ime, String prz, int god) {
		this.ime = ime;
		this.prz = prz;
		this.god = god;
	}
	
	public String toString() {
		return ime + " " + prz + ", " + god;
	}

	public String ime() { return ime; }
	public String prz() { return prz; }
	public int god() 	{ return god; }
}
