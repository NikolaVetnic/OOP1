package pv02_z02;

public class Objava {
	
	private String naslov, tema;
	private int brojKomentara;
	
	public enum Tema { 
		
		SPORT("sport"), 
		HOBIJI("hobiji"), 
		JEZICI("strani jezici"), 
		RAZNO("razno");
		
		private String tema;
		
		Tema(String tema) 		{ this.tema = tema; }
		public String tema() 	{ return tema; 		}
	}
	
	// constructor
	private Objava(String naslov, String tema, int brojKomentara) {
		this.naslov = naslov;
		setTema(tema);
		this.brojKomentara = brojKomentara;
	}
	
	public static Objava nova(String naslov, String tema, int brojKomentara) {
		return new Objava(naslov, tema, brojKomentara);
	}
	
	// methods
	protected static boolean jeValidnaTema(String tema) {
		
		for (Tema t : Tema.values())
			if (t.tema().equals(tema)) return true;
		
		return false;
	}
	
	// getters
	public String naslov() 		{ return naslov; 		}	
	public String tema() 		{ return tema; 			}
	public int brojKomentara() 	{ return brojKomentara; }
	
	// setters
	public void setTema(String tema) {
		if (jeValidnaTema(tema)) this.tema = tema;
		else this.tema = "razno"; 
	}
	public void setNaslov(String naslov) 			{ this.naslov = naslov; 			  }
	public void setBrojKomentara(int brojKomentara) { this.brojKomentara = brojKomentara; }

	// toString
	public String toString() {
		return naslov + " [" + tema + "] - broj komentara: " + brojKomentara;
	}
}
