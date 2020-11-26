package pv01_z02_p01;

public class Tim {

	private Kosarkas[] tim;

	public Tim(Kosarkas[] tim) {
		super();
		this.tim = tim;
	}

	@Override
	public String toString() {
		
		String out = "";
		
		for (int i = 0; i < tim.length; i++)
			out += tim[i] + "\n";

		return out;
	}
	
	public String najkorisnijiIgracNaTerenu() {
		
		int max_idx = 0;
		
		for (int i = 1; i < tim.length; i++)
			if (tim[i].getKorisnost() >= tim[max_idx].getKorisnost())
				max_idx = i;
		
		return tim[max_idx].getImePrezime();
	}
}
