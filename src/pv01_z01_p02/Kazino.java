package pv01_z01_p02;

public class Kazino {

	Kladionicar[] igraci;
	
	public Kazino(Kladionicar[] igraci) {
		this.igraci = igraci;
	}
	
	public String toString() {
		
		String out = "";
		
		for (Kladionicar i : igraci)
			out += i + " ";
		
		return out;
	}
	
	public void print() {
		
		for (Kladionicar i : igraci)
			System.out.println(i);
	}
	
	private int redniBrojIgre(String igra) {
		
		return igra.equals("ajnc")  ? 0 :
			   igra.equals("poker") ? 1 : 2;
	}
	
	public String najprofitnijaIgra() {
		
		int[] count = new int[3];
		
		for (Kladionicar i : igraci)
			if (i.stanje() < 0)
				count[redniBrojIgre(i.igra())]++;
		
		return String.format("Najprofitnija igra trenutno je %s.\n", 
				count[0] > count[1] ? (count[0] > count[2] ? "ajnc"  : "rulet") :
									  (count[1] > count[2] ? "poker" : "rulet"));
	}
}
