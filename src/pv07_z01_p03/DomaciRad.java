package pv07_z01_p03;

public class DomaciRad {

	private String imeUcenika;
	private String[] resenja;
	private int ocena;
	
	public DomaciRad(String imeUcenika, String[] resenja) {
		this.imeUcenika = imeUcenika;
		this.resenja = resenja;
	}

	public int ocena() 			{ return ocena; 		}
	public String imeUcenika() 	{ return imeUcenika; 	}
	public String[] resenja() 	{ return resenja; 		}
	
	public void setOcena(int o) { this.ocena = o;		}

	@Override
	public String toString() {
		
		String out = "";
		
		for (int i = 0; i < resenja.length; i++) {
			out += resenja[i] + ", ";
		}
		
		return imeUcenika + ", resenja: " + out + "ocena: " + ocena;
	}
}