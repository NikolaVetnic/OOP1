package kolokvijumi.kol_2020_06_p01;

import java.util.Random;

public abstract class Patike {
	
	public static Random rng = new Random(123813597236132938L);
//
//	public static final String[] TIP 	= { "DUBOKE", "PLITKE" };
//	public static final String[] VRSTA 	= { "ODRASLE", "DECIJE" };
//	public static final String[] BOJA 	= { "BELA", "CRNA", "CRVENA", "ZUTA", "KREM" };
	
	private String tip, vrsta, boja, marka;
	private double cena;
	private int broj;
	
	
	public Patike(String tip, String vrsta, String boja, double cena, int broj, String marka) {
		super();
		this.tip 	= tip;
		this.vrsta 	= vrsta;
		this.boja 	= boja;
		this.cena 	= cena;
		this.broj 	= broj;
		this.marka 	= marka;
	}
	
	
	public String toString() {
		return String.format("%-10s %-10s %-10s %8.2f RSD   %-4d %-10s", tip, vrsta, boja, cena, broj, marka);
	}


	public String tip() 	{ return tip; 	}	
	public String vrsta() 	{ return vrsta; }	
	public String boja() 	{ return boja; 	}
	public double cena() 	{ return cena; 	}
	public int broj() 		{ return broj; 	}
	public String marka() 	{ return marka; }
	
	public void setTip	(String tip) 	{ this.tip = tip; 		}
	public void setVrsta(String vrsta) 	{ this.vrsta = vrsta; 	}
	public void setBoja	(String boja) 	{ this.boja = boja; 	}
	public void setMarka(String marka) 	{ this.marka = marka; 	}
	public void setCena	(double cena) 	{ this.cena = cena; 	}
	public void setBroj	(int broj) 		{ this.broj = broj; 	}
}
