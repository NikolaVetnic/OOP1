package pv01_z02_p01;

public class Kosarkas {

	private String imePrezime;
	private String pozicija;
	private double korisnost;
	
	public Kosarkas(String imePrezime, String pozicija, double korisnost) {
		super();
		this.imePrezime = imePrezime;
		setPozicija(pozicija);
		this.korisnost = korisnost;
	}

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		
		if (pozicija.equals("krilo") || pozicija.equals("centar"))
			this.pozicija = pozicija;
		else 
			this.pozicija = "bek";
	}

	public double getKorisnost() {
		return korisnost;
	}

	public void setKorisnost(double korisnost) {
		this.korisnost = korisnost;
	}

	@Override
	public String toString() {
		return "[ " + imePrezime + ", " + pozicija + ", korisnost : " + korisnost + " ]";
	}
}
