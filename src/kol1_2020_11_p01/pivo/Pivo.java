package kol1_2020_11_p01.pivo;

public abstract class Pivo implements Comparable<Pivo> {

	private String proizvodjac;
	private double jacina;
	private String boja;
	private String tip;
	
	public String toString() {
		return String.format("%-14s %-6.2f %-14s %-10s", 
				proizvodjac, jacina, boja, tip);
	}

	public String proizvodjac() { return proizvodjac; 	}
	public double jacina() 		{ return jacina; 		}
	public String boja() 		{ return boja; 			}
	public String tip() 		{ return tip; 			}

	public void setProizvodjac	(String proizvodjac) 	{ this.proizvodjac = proizvodjac; 	}
	public void setJacina		(double jacina) 		{ this.jacina = jacina; 			}
	public void setBoja			(String boja) 			{ this.boja = boja; 				}
	public void setTip			(String tip) 			{ this.tip = tip; 					}
	
	abstract boolean jeIzlapelo();	// vraca da li je pivo pitko

	@Override
	public int compareTo(Pivo that) {
		return jacina - that.jacina < 0 ? -1 : (jacina - that.jacina == 0 ? 0 : 1);
	}
}
