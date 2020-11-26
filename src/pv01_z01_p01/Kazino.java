package pv01_z01_p01;

public class Kazino {

	private Kladionicar[] kladionicari;

	public Kazino(Kladionicar[] kladionicari) {
		super();
		this.kladionicari = kladionicari;
	}
	
	@Override
	public String toString() {
		
		String rez = "";
		
		for (int i = 0; i < kladionicari.length; i++)
			rez += kladionicari[i] + "\n";
		
		return rez;
	}
	
	public String najprofitabilnijaIgra() {
		
		int ajnc = 0, poker = 0, rulet = 0;
		
		for (int i = 0; i < kladionicari.length; i++)
			if (kladionicari[i].getStanje() < 0) {
				if (kladionicari[i].getIgra().equals("ajnc"))
					ajnc++;
				else if (kladionicari[i].getIgra().equals("poker"))
					poker++;
				else
					rulet++;
			}
		
		String out = "Najprofitnija igra trenutno je ";
		
		if (ajnc >= poker && ajnc >= rulet)
			return out + "ajnc.";
		
		if (poker >= ajnc && poker >= rulet)
			return out + "poker.";
		
		return out + "rulet.";
	}
}
