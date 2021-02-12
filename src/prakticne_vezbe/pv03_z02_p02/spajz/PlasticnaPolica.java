package prakticne_vezbe.pv03_z02_p02.spajz;

public class PlasticnaPolica extends Polica {

	public PlasticnaPolica(String proizv, int brjRed) {
		super(proizv, brjRed, 4.0);
	}
	

	protected boolean moguDaDodam(Tegla t) {
		
		return this.trnOpt < 2.5 || this.trnOpt + t.tez() < this.maxOpt;
	}
	
	
	@Override
	public boolean dodajTeglu(Tegla t) {
		
		if (!moguDaDodam(t))
			return false;
		
		tegle.add(t);
		addOpt(t.tez());
		
		return true;
	}
}
