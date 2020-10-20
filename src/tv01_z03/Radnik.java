package tv01_z03;

public class Radnik {
	
	private String ime;
	private int radniStaz;
	private double plata;
	
	public Radnik(String ime, double plata, int radniStaz) {
		this.ime = ime;
		this.radniStaz = radniStaz;
		this.plata = plata;
	}
	
	public double getPlata() { return plata; }
	
	public int getRadniStaz() { return radniStaz; }
	
	public String toString() {
		return ime + ", plata = " + plata + ", radni staz = " + radniStaz;
	}
}
