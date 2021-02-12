package prakticne_vezbe.pv07_z02_p03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barmen implements Mixer {
	
	
	List<VocniSok> sokovi;
	String[][] zabVoce;
	
	
	public Barmen(String[][] zabVoce) {
		this.zabVoce = zabVoce;
	}
	

	@Override
	public void dodajVoce(String voce, int brojKomada) throws GreskaDodavanje {
		
		if (sokovi == null) {
			
			sokovi = new ArrayList<VocniSok>();
			sokovi.add(new VocniSok(voce, brojKomada));
			
			return;
		}
		
		for (VocniSok s : sokovi)
			if (!jeMoguceDodati(s.vrs(), voce))
				throw new GreskaDodavanje(s, voce);
		
		sokovi.add(new VocniSok(voce, brojKomada));
	}
	

	private boolean jeMoguceDodati(String v0, String v1) {
		
		for (int i = 0; i < zabVoce.length; i++)
			if ((zabVoce[i][0].equals(v0) && zabVoce[i][1].equals(v1)) || 
				(zabVoce[i][1].equals(v0) && zabVoce[i][0].equals(v1))  )
				return false;
		
		return true;
	}
	

	@Override
	public void promuckaj() throws GreskaMuckanje {
		
		if (new Random().nextDouble() < 1.0 / 3) {
			anuliraj();
			throw new GreskaMuckanje("prosipanje");
		}
		
		if (new Random().nextDouble() < 1.0 / 7) {
			anuliraj();
			throw new GreskaMuckanje("razbijanje");
		}
		
		posluzi();
	}
	

	@Override
	public void posluzi() {
		System.out.print("SLUZIM sok : ");
		printSokovi();
		anuliraj();
	}
	
	
	public boolean imaVoca() {
		return sokovi != null && sokovi.size() > 0;
	}
	
	
	public void anuliraj() {
		sokovi = null;
	}
	

	public void printSokovi() {
		for (VocniSok s : sokovi)
			System.out.print(s + " | ");
		System.out.println();
	}
}
