package kol1_2020_11_b_p01;

public abstract class Uredjaj {
	private double jacinaProcesora;
	private int ramMemorija;
	private boolean imaKameru;
	private double cena;
	private String boja;
	
	public Uredjaj(String boja, double jacinaProcesora, int ramMemorija, double cena, boolean imaKameru) {
		this.jacinaProcesora = jacinaProcesora;
		this.ramMemorija = ramMemorija;
		this.imaKameru = imaKameru;
		this.cena = cena;
		setBoja(boja);
	}

	public double getJacinaProcesora() {
		return jacinaProcesora;
	}

	public void setJacinaProcesora(double jacinaProcesora) {
		this.jacinaProcesora = jacinaProcesora;
	}

	public int getRamMemorija() {
		return ramMemorija;
	}

	public void setRamMemorija(int ramMemorija) {
		this.ramMemorija = ramMemorija;
	}

	public boolean isImaKameru() {
		return imaKameru;
	}

	public void setImaKameru(boolean imaKameru) {
		this.imaKameru = imaKameru;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		if (boja.equals("crna")) {
			this.boja = boja;
		} else if (boja.equals("bela")) {
			this.boja = boja;
		} else {
			this.boja = "siva";
		}
	}
	
	public abstract boolean jePotrebanServis();
	
	@Override 
	public String toString() {
		return getClass().getSimpleName() + " " + boja + " " + jacinaProcesora + " " + ramMemorija + " " + cena;
	}

	
}
