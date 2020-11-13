package tv02_z05;

public class Student {

	private int id;
	private String ime;
	private double prosek;
	private String departman;
	
	private static int idCounter = 0;
	private static final double odlicanProsek = 9.5;
	
	private Student(String ime, double prosek, String departman) {
	
		id = ++idCounter;
		
		this.ime = ime;
		this.prosek = prosek;
		this.departman = departman;
	}
	
	public static Student novi(String ime, double prosek, String departman) {
		
		return new Student(ime, prosek, departman);
	}
	
	public String toString() {
		return id + ": " + ime + " ( " + prosek + ") -- " + departman;
	}

	public int id() 			{ return id; 		}
	public String ime() 		{ return ime; 		}
	public double prosek() 		{ return prosek; 	}
	public String departman() 	{ return departman; }
	
	public boolean dobijaNagradu() {
		return prosek >= odlicanProsek;
	}
}
