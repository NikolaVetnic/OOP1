package pv03_z02_p01.spajz;

public class Tegla {

	private double zapremina, tezina;
	private String sadrzaj;
	
	private Tegla(double zapremina, double tezina, String sadrzaj) {
		this.zapremina = zapremina;
		this.tezina = tezina;
		this.sadrzaj = sadrzaj;
	}
	
	public static Tegla nova(double zapremina, double tezina, String sadrzaj) {
		return new Tegla(zapremina, tezina, sadrzaj);
	}
	
	public String toString() {
		return String.format("%-10s [ %.1f l ] [ %.1f kg ]", sadrzaj, zapremina, tezina);
	}
	
	public double zapremina() 	{ return zapremina; }
	public double tezina() 		{ return tezina; 	}
	public String sadrzaj()		{ return sadrzaj;	}
}
