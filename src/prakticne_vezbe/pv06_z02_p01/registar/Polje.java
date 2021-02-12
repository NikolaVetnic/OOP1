package prakticne_vezbe.pv06_z02_p01.registar;

public abstract class Polje {

	
	private double povrsina;		// u hektarima
	private double ocekivaniPrinos;	// u tonama
	private int brRadnika;			// potrebno da obradjuje
	
	
	public String toString() {
		return String.format("P : %6.2f  Ocekivani prinos: %6.2f  Broj radnika: %4d", povrsina, ocekivaniPrinos, brRadnika);
	}
	
	
	public double povrsina() 		{ return povrsina; 			}
	public double ocekivaniPrinos() { return ocekivaniPrinos; 	}
	public int brRadnika() 			{ return brRadnika; 		}

	
	public void setPovrsina(double povrsina) 				{ this.povrsina = povrsina; 				}
	public void setOcekivaniPrinos(double ocekivaniPrinos) 	{ this.ocekivaniPrinos = ocekivaniPrinos; 	}
	public void setBrRadnika(int brRadnika) 				{ this.brRadnika = brRadnika; 				}
	
	
	/**
	 * Računa potencijalnu zaradu na ovom polju.
	 */
	public abstract double potencijalnaZarada();
}
