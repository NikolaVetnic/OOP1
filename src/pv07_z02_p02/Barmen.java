package pv07_z02_p02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Barmen implements Mixer {
	
	
	private List<VocniSok> sokovi;
	private String[][] zabVoce;
	
	
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
			if (!jeMoguceDodati(s, voce))
				throw new GreskaDodavanje(s, voce);
		
		sokovi.add(new VocniSok(voce, brojKomada));
		return;
	}

	private boolean jeMoguceDodati(VocniSok s, String voce) {
		
		String v0 = s.vrs(), 
			   v1 = voce;
		
		for (String[] par : zabVoce)
			if ((v0.equals(par[0]) && v1.equals(par[1])) || (v0.equals(par[1]) && v1.equals(par[0])))
				return false;
		
		return true;
	}
	
	
	public boolean imaVoca() {
		return sokovi != null && sokovi.size() != 0;
	}


	@Override
	public void promuckaj() throws GreskaMuckanje {
		
		if (new Random().nextDouble() < 1.0 / 3) {
			anuliraj();
			throw new GreskaMuckanje("prosipanje");
		} else if (new Random().nextDouble() < 1.0 / 7) {
			anuliraj();
			throw new GreskaMuckanje("razbijanje");
		} else {
			posluzi();
		}
	}

	@Override
	public void posluzi() {
		System.out.print("Posluzujem sok : ");
		printSokovi();
		anuliraj();
	}
	
	public void anuliraj() {
		this.sokovi = null;
	}
	
	public void printSokovi() {
		for (VocniSok s : sokovi)
			System.out.print(s + " | ");
		
		System.out.println();
	}

	public void printZabVoce() {
		if (zabVoce != null)
			for (int i = 0; i < zabVoce.length; i++)
				System.out.println(zabVoce[i][0] + ", " + zabVoce[i][1]);
		else
			System.out.println("Zabranjeno voce nije ucitano!");
	}
}
