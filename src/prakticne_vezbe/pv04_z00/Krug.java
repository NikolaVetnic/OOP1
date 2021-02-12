package prakticne_vezbe.pv04_z00;

public class Krug extends GeometrijskaFigura {

	private int poluprecnik;
	
	public Krug(Tacka srediste, int poluprecnik) {
		super(srediste);
		this.poluprecnik = poluprecnik;
	}

	@Override
	public boolean stajeNaEkran(Ekran e) {
		
		Tacka[] kriticneTacke = {
				new Tacka(srediste.x(), srediste.y() - poluprecnik),
				new Tacka(srediste.x(), srediste.y() + poluprecnik),
				new Tacka(srediste.x() - poluprecnik, srediste.y()),
				new Tacka(srediste.x() + poluprecnik, srediste.y()),
		};
		
		for (int i = 0; i < kriticneTacke.length; i++)
			if (!e.naEkranu(kriticneTacke[i]))
				return false;
		
		return true;
	}
}
