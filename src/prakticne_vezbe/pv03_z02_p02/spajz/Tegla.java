package prakticne_vezbe.pv03_z02_p02.spajz;

public class Tegla {
	

	private final double zap;
	private double tez;
	private String sad;
	
	
	public Tegla(double zap, double tez, String sad) {
		this.zap = zap;
		napuniTeglu(tez, sad);
	}
	
	public Tegla(double zap) {
		this(zap, 0.0, "");
	}
	
	
	public void napuniTeglu(double tez, String sad) {
		
		this.sad = sad;
		this.tez = tez;
	}
	
	
	public String toString() {
		return String.format("Sadrzaj : %-12s zapremina: %-6.2f tezina: %-6.2f", sad, zap, tez);
	}
	

	public double zap() { return zap; }
	public double tez() { return tez; }
	public String sad() { return sad; }
}
