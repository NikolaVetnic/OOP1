package pv02_z01_p02;

public class Kurs {
	

	private final String jezik;
	private String nivo;
	private int brPolaznika;
	
	
	private Kurs(String jezik, String nivo, int brPolaznika) {
		this.jezik = jezik;
		setNivo(nivo);
		this.brPolaznika = brPolaznika;
	}
	
	public static Kurs novi(String jezik, String nivo, int brPolaznika) {
		return new Kurs(jezik, nivo, brPolaznika);
	}
	
	public String toString() {
		return String.format("[ %s (%s), broj polaznika: %d ]", jezik, nivo, brPolaznika);
	}

	
	public String jezik() 		{ return jezik; 		}
	public String nivo() 		{ return nivo; 			}
	public int brPolaznika() 	{ return brPolaznika; 	}

	
	public void setNivo(String nivo) {
		this.nivo = nivo.equals("napredni") ? "napredni" : 
					nivo.equals("srednji")  ? "srednji"  : "osnovni";
	}
	
	protected void podigniNivo() {
		
		if 		(nivo.equals("napredni")) 	return;
		else if (nivo.equals("srednji" )) 	setNivo("napredni");
		else 								setNivo("srednji");
	}

	public void setBrPolaznika(int brPolaznika) {
		this.brPolaznika = brPolaznika;
	}
}
