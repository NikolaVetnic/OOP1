package pv01_z01;

public class Kladionicar {

	private String ime;
	private String igra;
	private int stanje;
	
	public Kladionicar(String ime, String igra, int stanje) {
		super();
		this.ime = ime;
		this.stanje = stanje;
		setIgra(igra);
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getIgra() {
		return igra;
	}
	
	public void setIgra(String igra) {
		
		if (igra.equals("ajnc") || igra.equals("rulet"))
			this.igra = igra;
		else 
			this.igra = "poker";
	}

	public int getStanje() {
		return stanje;
	}
	
	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return this.ime + " igra " + this.igra + " i ima " + this.stanje + " na racunu.";
	}
}
