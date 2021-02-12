package usmeni_ispit.qA09_nasledjivanje;

public class Radnik {
	
	
	protected String ime;
	protected int radniStaz;
	
	
	public Radnik(String ime, int radniStaz) {
		this.ime = ime;
		this.radniStaz = radniStaz;
	}
	
	
	public String toString() {
		return ime + ": " + radniStaz;
	}
}
