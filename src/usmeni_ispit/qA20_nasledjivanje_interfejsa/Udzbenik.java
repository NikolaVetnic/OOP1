package usmeni_ispit.qA20_nasledjivanje_interfejsa;

public class Udzbenik implements Knjiga {
	
	private String ime;
	private String autor;
	private SadrzajKnjige sadrzaj;

	public Udzbenik(String ime, String autor) {
		this.ime = ime;
		this.autor = autor;
		this.sadrzaj = new SadrzajKnjige();
	}
	
	public String naslov() { return ime; 	}
	public String autor()  { return autor; 	}

	@Override
	public void dodajUSadrzaj(String naslov, int strana) {
		this.sadrzaj.dodaj(naslov, strana);
	}

	@Override
	public Knjiga.IspisivacSadrzaja sadrzaj() {
		return sadrzaj;
	}
}
