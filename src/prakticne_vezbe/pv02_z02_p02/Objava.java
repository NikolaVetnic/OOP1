package prakticne_vezbe.pv02_z02_p02;

public class Objava {
	
	private static final String[] TEME = {
			"sport", "hobiji", "strani jezici", "muzika", "razno"
	};

	private String naslov;
	private String tema;
	private int brKomentara;
	
	private Objava(String naslov, String tema, int brKomentara) {
		this.naslov = naslov;
		setTema(tema);
		this.brKomentara = brKomentara;
	}
	
	public static Objava nova(String naslov, String tema, int brKomentara) {
		return new Objava(naslov, tema, brKomentara);
	}
	
	
	public String toString() {
		return String.format("%s [%s] - broj komentara %d", naslov, tema, brKomentara);
	}
	
	
	public String naslov() 		{ return naslov; 		}
	public String tema() 		{ return tema; 			}
	public int brKomentara() 	{ return brKomentara; 	}
	
	public void setTema(String tema) {
		
		String s = "";
		
		for (String t : TEME) if (tema.equals(t)) s = t;
		if (s.equals("")) s = TEME[TEME.length - 1];
		
		this.tema = s;
	}
	
	public void setNaslov(String naslov) 		{ this.naslov = naslov; 			}
	public void setBrKomentara(int brKomentara) { this.brKomentara = brKomentara; 	}
}
