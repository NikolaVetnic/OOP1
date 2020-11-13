package pv04_z00;

abstract class GeometrijskaFigura {

	protected Tacka srediste;
	
	public GeometrijskaFigura(Tacka srediste) {
		this.srediste = srediste;
	}
	
	public void transliraj(Tacka pomeraj) {
		srediste.setX(srediste.x() + pomeraj.x());
		srediste.setY(srediste.y() + pomeraj.y());
	}
	
	public abstract boolean stajeNaEkran(Ekran e);
	
	public void translirajAkoStajeNaEkran(Tacka pomeraj, Ekran e) {
		
		transliraj(pomeraj);
		
		if(!stajeNaEkran(e)) {
			srediste.setX(srediste.x() - pomeraj.x());
			srediste.setY(srediste.y() - pomeraj.y());
		}
	}
}
