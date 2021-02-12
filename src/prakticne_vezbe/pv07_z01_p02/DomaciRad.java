package prakticne_vezbe.pv07_z01_p02;

public class DomaciRad {

	private String ime;
	private String[] resenja;
	private int ocena;
	
	public DomaciRad(String ime, String[] resenja) {
		this.ime = ime;
		this.resenja = resenja;
	}

	public String ime() 		{ return ime; 		}
	public String[] resenja() 	{ return resenja; 	}
	public int ocena() 			{ return ocena; 	}
	
	public void setOcena(int o) { this.ocena = o;	}
	
	@Override
	public String toString() {
		String out = "";
		
		for (int i = 0; i < resenja.length; i++) {
			out += resenja[i] + ", ";
		}
		
		return ime + ", resenja: " + out + "ocena: " + ocena;
	}
}
