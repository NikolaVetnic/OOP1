package kol_2020_06_p01;

public class Kupac {

	private String 	ime;
	private int 	god;
	private double 	nvc;
	
	public Kupac(String ime, int god, double d) {
		this.ime = ime;
		this.god = god;
		this.nvc = d;
	}

	public String ime() { return ime; }
	public int god() 	{ return god; }
	public double nvc() { return nvc; }

	public void setIme(String ime) 	{ this.ime = ime; }
	public void setGod(int god) 	{ this.god = god; }
	public void setNvc(double nvc) 	{ this.nvc = nvc; }
	
	public String toString() {
		return "[ " + ime + " (" + god + "), " + nvc + "RSD ]";
	}
}
