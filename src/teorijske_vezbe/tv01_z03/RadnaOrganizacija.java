package teorijske_vezbe.tv01_z03;

public class RadnaOrganizacija {
	
	private Radnik[] zaposleni;
	private int brZaposlenih;

	public RadnaOrganizacija(int maxZaposlenih) {
		this.zaposleni = new Radnik[maxZaposlenih];
	}
	
	public int getBrZaposlenih() { return brZaposlenih; }
	public void setBrZaposlenih(int that) { this.brZaposlenih = that; } 

	public boolean dodajRadnika(String ime, double plata, int radniStaz) {
		
		if (brZaposlenih < zaposleni.length) {
			zaposleni[brZaposlenih++] = new Radnik(ime, plata, radniStaz);
			return true;
		} else {
			return false;
		}
	}
	
	public Radnik maxStaz() {
		
		int idx = 0;
		
		for (int i = 1; i < brZaposlenih; i++)
			if (zaposleni[i].getRadniStaz() > zaposleni[idx].getRadniStaz())
				idx = i;
		
		return zaposleni[idx];
	}
	
	public double prosekPlata() {
		
		if (brZaposlenih == 0)
			return Double.NaN;
		
		double sum = zaposleni[0].getPlata();
		
		for (int i = 1; i < brZaposlenih; i++)
			sum += zaposleni[i].getPlata();
		
		return sum / brZaposlenih;
	}
}
