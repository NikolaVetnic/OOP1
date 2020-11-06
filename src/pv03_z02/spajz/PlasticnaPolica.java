package pv03_z02.spajz;

public class PlasticnaPolica extends Polica {

	protected PlasticnaPolica(String proizvodjac, int brRedova) {
		super(proizvodjac, brRedova, 4.0);
	}
	
	public static PlasticnaPolica nova(String proizvodjac, int brRedova) {
		return new PlasticnaPolica(proizvodjac, brRedova);
	}
	
	@Override
	public boolean dodajTeglu(double zapremina, double tezina, String sadrzaj) {
		
		if (brTegli() == MAX_TEGLI || trenutnaTezina() > 2.5) {
//			System.out.println("Dodavanje tegle na PLASTICNU policu je NEUSPESNO.");
			return false;
		}
		
		tegle[brTegli++] = Tegla.nova(zapremina, tezina, sadrzaj);
		setTrenutnaTezina(this.trenutnaTezina + tezina);
		
		return true;
	}
	
	@Override
	public void setTrenutnaTezina(double trenutnaTezina) {
		this.trenutnaTezina = trenutnaTezina <= maxTezina ? trenutnaTezina : maxTezina;
	}
}
