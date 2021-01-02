package pv07_z02_p02;

public class VocniSok {
	
	public static double KOL_PO_KOMADU = 0.1;

	private String 	vrs;
	private int 	kom;
	private double 	kol;
	
	public VocniSok(String vrs, int kom) {
		this.vrs = vrs;
		setKom(kom);
	}

	public String vrs() { return vrs; }
	public int kom() 	{ return kom; }
	public double kol() { return kol; }

	public void setKom(int kom) {
		this.kom = kom;
		this.kol = kom * KOL_PO_KOMADU;
	}
	
	public String toString() {
		return vrs + ", kom: " + kom + ", kol: " + kol;
	}
}
