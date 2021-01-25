package usmeni_ispit.qA20_nasledjivanje_interfejsa;

public interface Knjiga {

	String naslov();
	String autor();
	
	void dodajUSadrzaj(String naslov, int strana);
	IspisivacSadrzaja sadrzaj();
	
	interface IspisivacSadrzaja {
		boolean imaJos();
		String sledeciNaslovIStrana();
	}
}
