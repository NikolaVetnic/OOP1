package pv04_z03_p01;

public abstract class Lekar {

	private String ime, prz;
	private Pacijent[] pacijenti;
	private int brPac;
	
	public Lekar(String ime, String prz, int maxPac) {
		this.ime = ime;
		this.prz = prz;
		this.pacijenti = new Pacijent[maxPac];
		this.brPac = 0;
	}
	
	public String toString() {
		return "dr " + ime + " " + prz + ", broj pacijenata: " + brPac;
	}

	public String ime() 			{ return ime; 				}
	public String prz() 			{ return prz; 				}
	public Pacijent[] pacijenti() 	{ return pacijenti; 		}
	public Pacijent pacijent(int i) { return pacijenti[i]; 		}
	public int brPac() 				{ return brPac; 			}
	public int maxPac() 			{ return pacijenti.length; 	}
	
	private boolean imaMesta() 		{ return brPac < pacijenti.length; }
	
	public boolean prihvati(Pacijent p) {
		
		if (!imaMesta()) return false;
		
		pacijenti[brPac++] = p;
		return true;
	}
	
	public abstract int plata();
}
