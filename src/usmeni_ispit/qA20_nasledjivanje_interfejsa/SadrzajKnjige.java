package usmeni_ispit.qA20_nasledjivanje_interfejsa;

import java.util.ArrayList;

public class SadrzajKnjige implements Knjiga.IspisivacSadrzaja {
	
	// elementi sadrzaja
	private ArrayList<String> elementi = new ArrayList<>();
	
	// indeks elementa koga treba ispisati
	private int pozicija = 0;

	public void dodaj(String naslov, int strana) {
		String novi = naslov + "--" + strana;
		elementi.add(novi);
	}
	
	@Override
	public boolean imaJos() {
		return pozicija < elementi.size();
	}

	@Override
	public String sledeciNaslovIStrana() {
		if (imaJos())
			return elementi.get(pozicija++);
		else
			return null;
	}
}
