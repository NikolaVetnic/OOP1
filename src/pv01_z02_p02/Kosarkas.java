package pv01_z02_p02;

public class Kosarkas {

	private final String 	ime;
	private String 			poz;
	private double 			kor;
	
	public Kosarkas(String ime, String poz, double kor) {
		this.ime = ime;
		this.setPoz(poz);
		this.kor = kor;
	}
	
	public String toString() {
		return String.format("[ %s, %s, korisnost: %.2f ]", ime, poz, kor);
	}

	public String poz() 	{ return poz; }
	public double kor() 	{ return kor; }
	public String ime() 	{ return ime; }

	public void setKor(double kor) { this.kor = kor; }
	
	public void setPoz(String poz) {
		this.poz = poz.equals("centar") ? "centar" : 
				   poz.equals("krilo")  ? "krilo"  : "bek";
	}
}
