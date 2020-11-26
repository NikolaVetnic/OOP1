package pv01_z01_p02;

public class Kladionicar {

	private final String ime;
	private String igra;
	private int stanje;
	
	public Kladionicar(String ime, String igra, int stanje) {
		this.ime = ime;
		this.igra = igra;
		this.stanje = stanje;
	}
	
	public String toString() {
		return String.format("%10s %10s trenutno stanje: %-5d", ime, igra, stanje);
	}

	public String ime() 	{ return ime; 		}
	public String igra() 	{ return igra; 		}
	public int stanje() 	{ return stanje; 	}
	
	public void setIgra(String igra) {
		
		this.igra = igra.equals("ajnc")  ? "ajnc"  :
					igra.equals("rulet") ? "rulet" : "poker";
	}
}
