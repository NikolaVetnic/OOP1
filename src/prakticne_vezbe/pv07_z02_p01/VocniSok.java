package prakticne_vezbe.pv07_z02_p01;

public class VocniSok {
	
	
	private static final double KOL_PO_KOMADU = 0.1;

	
	private String 	vrs;
	private int		kom;
	private double	kol;
	
	
	public VocniSok(String vrs, int kom) {
		this.vrs = vrs;
		setKom(kom);
	}
	
	
	public String toString() {
		return vrs + ", kom: " + kom + ", kol: " + kol;
	}
	
	
	public int kom() 	{ return kom; }
	public String vrs() { return vrs; }
	public double kol() { return kol; }
	
	
	public void setKom(int kom) { 
		this.kom = kom;
		this.kol = kom * KOL_PO_KOMADU;
	}
}
