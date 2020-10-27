package tv02_z06;

public class Rukovodilac extends Radnik {

	private int brPodredjenih;
	private static final double dodatak = 1e3;
	
	protected Rukovodilac(String ime, int radniStaz, int brPodredjenih) {
		super(ime, radniStaz);
		this.brPodredjenih = brPodredjenih;
	}
	
	public static Rukovodilac novi(String ime, int radniStaz, int brPodredjenih) {
		return new Rukovodilac(ime, radniStaz, brPodredjenih);
	}
	
	public double plata() { return super.plata() + dodatak * brPodredjenih; }
	
	public int brPodredjenih() { return brPodredjenih; }
	
	public String toString() {
		return "Rukovodilac " + super.toString(); 
	}
}
