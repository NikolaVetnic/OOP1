package kolokvijumi.kol2_2021_01_a_p01;

public class Ukras {
	

	private String boja;
	private double tezina, cena;
	
	
	public Ukras(String boja, double tezina, double cena) {
		this.boja = boja;
		this.tezina = tezina;
		this.cena = cena;
	}
	

	public String boja() 	{ return boja; 		}
	public double tezina() 	{ return tezina; 	}
	public double cena() 	{ return cena; 		}
	
	
	public String inDetail() {
		return "[ boja: " + boja + ", tezina: " + tezina + ", cena: " + cena + " RSD ]";
	}
	
	@Override
	public String toString() {
		return "" + tezina + "g, " + cena + "RSD, boja: " + boja;
	}
}
