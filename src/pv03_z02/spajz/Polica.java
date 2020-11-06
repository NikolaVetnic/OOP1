package pv03_z02.spajz;

public class Polica {
	
	protected static final int MAX_TEGLI = 10;

	protected final String proizvodjac;
	protected final int brRedova;
	protected final double maxTezina;
	
	protected double trenutnaTezina;
	protected Tegla[] tegle;
	protected int brTegli;
	
	protected Polica(String proizvodjac, int brRedova, double maxTezina) {
		this.proizvodjac = proizvodjac;
		this.brRedova = brRedova;
		this.maxTezina = maxTezina;
		this.trenutnaTezina = 0.0;
		
		this.tegle = new Tegla[MAX_TEGLI];
		this.brTegli = 0;
	}
	
	public static Polica nova(String proizvodjac, int brRedova, double maxTezina) {
		return new Polica(proizvodjac, brRedova, maxTezina);
	}
	
	public boolean dodajTeglu(double zapremina, double tezina, String sadrzaj) {
		
		if (this.brTegli == MAX_TEGLI || this.trenutnaTezina + tezina > this.maxTezina) {
//			System.out.println("Dodavanje tegle na policu je NEUSPESNO.");
			return false;
		}
		
		tegle[brTegli++] = Tegla.nova(zapremina, tezina, sadrzaj);
		setTrenutnaTezina(this.trenutnaTezina + tezina);
		
		return true;
	}
	
	public boolean dodajTeglu(Tegla t) {
		return dodajTeglu(t.zapremina(), t.tezina(), t.sadrzaj());
	}
	
	public double ukupnaZapremina() {
		
		double sum = .0;
		
		for (int i = 0; i < brTegli; i++)
			sum += tegle[i].zapremina();
		
		return sum;
	}
	
	public String toString() {
		return String.format("%-15s [ %.1f / %.1f kg, ukupna zapremina %.1f l )\n", proizvodjac, trenutnaTezina, maxTezina, ukupnaZapremina());
	}
	
	public String proizvodjac() 	{ return proizvodjac; 		}
	public int brRedova()			{ return brRedova; 			}
	public double maxTezina() 		{ return maxTezina; 		}
	public double trenutnaTezina() 	{ return trenutnaTezina; 	}
	public static int maxTegli() 	{ return MAX_TEGLI; 		}
	public int brTegli() 			{ return brTegli; 			}
	
	public Tegla tegla(int i) {
		return tegle != null && 0 <= i && i <= brTegli ? tegle[i] : null; 
	}
	
	public void setTrenutnaTezina(double trenutnaTezina) {
		this.trenutnaTezina = trenutnaTezina <= maxTezina ? trenutnaTezina : maxTezina;
	}
}
