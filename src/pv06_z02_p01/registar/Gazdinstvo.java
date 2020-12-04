package pv06_z02_p01.registar;

public class Gazdinstvo {

	
	private static final int MAX_POLJA = 5;
	
	
	private final String ime;
	private int satnica;
	
	private Polje[] polja;
	private int brPolja;
	
	
	public static class PoljePsenice extends Polje {
		
		public static final int BROJ_RADNIKA_PO_HEKTARU = 2;
		public static final double CENA_PO_KG = 20.0;

		public PoljePsenice(double povrsina, double ocekivaniPrinos) {
			super();
			this.setPovrsina(povrsina);
			this.setOcekivaniPrinos(ocekivaniPrinos);
			this.setBrRadnika((int) (povrsina + 0.5) * BROJ_RADNIKA_PO_HEKTARU);
		}
		
		public String toString() {
			return "PSENICA " + super.toString();
		}
		
		@Override
		public double potencijalnaZarada() {
			return this.ocekivaniPrinos() * 1000.0 * CENA_PO_KG;
		}
	}
	
	
	public static class PoljeKukuruza extends Polje {
		
		public static final int BROJ_RADNIKA_PO_HEKTARU = 3;
		public static final double CENA_PO_KG = 15.0;

		public PoljeKukuruza(double povrsina, double ocekivaniPrinos) {
			super();
			this.setPovrsina(povrsina);
			this.setOcekivaniPrinos(ocekivaniPrinos);
			this.setBrRadnika((int) (povrsina + 0.5) * BROJ_RADNIKA_PO_HEKTARU);
		}
		
		public String toString() {
			return "KUKURUZ " + super.toString();
		}
		
		@Override
		public double potencijalnaZarada() {
			return this.ocekivaniPrinos() * 1000.0 * CENA_PO_KG;
		}
	}
	
	
	public Gazdinstvo(String ime, int satnica) {
		this.ime = ime;
		this.satnica = satnica;
		this.polja = new Polje[MAX_POLJA];
		this.brPolja = 0;
	}
	
	
	public void stampaj() {
		System.out.printf("%-20s (%d / h)\n", ime, satnica);
		for (int i = 0; i < brPolja; i++)
			System.out.println("\t" + polja[i]);
	}
	
	
	public void dodajPolje(Polje p) {
		
		if (brPolja == MAX_POLJA) {
			System.out.println("Maksimalan broj polja dostignut.");
			return;
		}
		
		polja[brPolja++] = p;
	}

	
	public static int maxPolja() 	{ return MAX_POLJA; }
	public String ime() 			{ return ime; 		}
	public int satnica() 			{ return satnica; 	}
	public Polje[] polja() 			{ return polja; 	}
	public Polje polje(int i) 		{ return polja[i]; 	}
	public int brPolja() 			{ return brPolja; 	}
}
