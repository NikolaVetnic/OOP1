package teorijske_vezbe.tv02_z06;

public class Radnik {

	private String ime;
	private int radniStaz;
	private static final double koeficijent = 1e4;
	
	protected Radnik(String ime, int radniStaz) {
		this.ime = ime;
		this.radniStaz = radniStaz;
	}
	
	public static Radnik novi(String ime, int radniStaz) {
		return new Radnik(ime, radniStaz);
	}
	
	public double plata() { return radniStaz * koeficijent; }
	
	public String toString() {
		return ime + ", " + radniStaz + ", " + plata();
	}
}
