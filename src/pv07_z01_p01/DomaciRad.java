package pv07_z01_p01;

public class DomaciRad {

	private String imeUcenika;
	private String[] resenja;
	private int ocena;
	
	public DomaciRad(String imeUcenika, String[] resenja) {
		this.imeUcenika = imeUcenika;
		this.resenja = resenja;
		this.ocena = 1;
	}

	public String imeUcenika()		{ return imeUcenika;	}
	public String[] resenja()		{ return resenja;		}
	public int ocena() 				{ return ocena; 		}
	public void setOcena(int ocena) { this.ocena = ocena; 	}	
	
	@Override
	public String toString() {
		String out = "";
		
		for (int i = 0; i < resenja.length; i++) {
			out += resenja[i] + ", ";
		}
		
		return imeUcenika + ", resenja: " + out + "ocena: " + ocena;
	}
}
