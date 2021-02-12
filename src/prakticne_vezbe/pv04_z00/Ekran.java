package prakticne_vezbe.pv04_z00;

public class Ekran {

	private int duzina, sirina;
	
	public Ekran(int duzina, int sirina) {
		if (duzina <= 0 || sirina <= 0)
			throw new IllegalArgumentException("Nedozvoljene dimenzije.");
		
		this.duzina = duzina;
		this.sirina = sirina;
	}
	
	public int duzina()	{ return duzina; }
	public int sirina()	{ return sirina; }
	
	public boolean naEkranu(Tacka t) {
		return 0 <= t.x() && t.x() < duzina &&
			   0 <= t.y() && t.y() < sirina  ;
	}
}
