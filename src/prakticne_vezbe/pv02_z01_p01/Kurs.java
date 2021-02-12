package prakticne_vezbe.pv02_z01_p01;

public class Kurs {

	private String jezik, nivo;
	private int brP;
	
	private Kurs(String jezik, String nivo, int brP) {
		this.jezik = jezik;
		setNivo(nivo);
		setBrP(brP);
	}
	
	public static Kurs novi(String jezik, String nivo, int brP) {
		return new Kurs(jezik, nivo, brP);
	}
	
	public String toString() {
		return String.format("%-10s : %-10s [ %2d ]", jezik, nivo, brP);
	}
	
	public String jezik() 	{ return jezik; }
	public String nivo() 	{ return nivo; 	}
	public int brP()		{ return brP;	}
	
	public void setNivo(String nivo) {
		this.nivo = nivo.equals("napredni") ? nivo : 
					nivo.equals("srednji")  ? nivo : "osnovni";
	}
	
	public void setBrP(int brP) {
		this.brP = brP > 0 ? brP : 0;
	}
}
