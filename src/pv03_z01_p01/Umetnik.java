package pv03_z01_p01;

public class Umetnik {

	
	public static final int TRENUTNA_GODINA = 2020;
	

	private final String ime;
	private UmetnickoDelo[] dela;
	private int brDela;
	private int maxDela;
	
	
	public Umetnik(String ime, UmetnickoDelo[] dela, int maxDela) {
		this.ime = ime;
		this.maxDela = maxDela;
		
		this.dela = new UmetnickoDelo[maxDela];
		for (int i = 0; i < maxDela && i < dela.length; i++)
			this.dela[i] = dela[i];
		
		if (this.dela.length < dela.length)
			System.out.printf("UPOZORENJE: Maksimum dostignut; poslednjih %d dela nije dodato.\n", dela.length - this.dela.length);

		this.brDela = this.dela.length < dela.length ? maxDela : dela.length;
	}
	
	
	public Umetnik(String ime, int maxDela) {
		this.ime = ime;
		this.maxDela = maxDela;
		this.dela = new UmetnickoDelo[maxDela];
		this.brDela = 0;
	}
	
	
	public String toString() {
		
		String out = "[ " + ime + " : ";
		
		for (UmetnickoDelo d : dela)
			out += d + " ";
		
		return out + "]";
	}
	
	
	public void print() {
		
		System.out.printf("%s (%d / %d dela)\n", ime, brDela, maxDela);
		
		for (UmetnickoDelo d : dela)
			if (d != null) System.out.println(d);
		
		System.out.println();
	}
	

	public String ime() 			{ return ime; 		}
	public UmetnickoDelo[] dela() 	{ return dela; 		}
	public int brDela() 			{ return brDela; 	}
	public int maxDela() 			{ return maxDela; 	}
	
	
	public boolean izlozi(UmetnickoDelo d) {
		
		if (brDela == maxDela) {
			System.out.println("UPOZORENJE: Maksimum dostignut; nemoguce je izloziti nova dela.");
			return false;
		}
		
		dela[brDela++] = d;
		return true;
	}
	
	
	public double vrednost() {
		
		double sum = 0.0;
		
		for (UmetnickoDelo d : dela) if (d != null) sum += d.cena();
		
		System.out.printf("Cena svih izlozenih dela umetnika %s je: %.2f EUR\n", ime, sum);
		return sum;
	}
	
	
	public int godNajstarijeg() {
		
		int god = TRENUTNA_GODINA;
		
		if (dela == null) return god;
		
		for (UmetnickoDelo d : dela)
			if (d != null && d.god() < god)
				god = d.god();
		
		return god;
	}
}
