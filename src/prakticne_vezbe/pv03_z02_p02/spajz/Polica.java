package prakticne_vezbe.pv03_z02_p02.spajz;

import java.util.ArrayList;
import java.util.List;

public class Polica {
	
	
	static final double DEFAULT_MAXOPT = 10.0;
	

	protected final String proizv;
	protected final int brjRed;
	protected final double maxOpt;
	
	protected List<Tegla> tegle;
	protected double trnOpt;
	
	
	public Polica(String proizv, int brjRed, double maxOpt) {
		this.proizv = proizv;
		this.brjRed = brjRed;
		this.maxOpt = maxOpt;
		
		this.tegle = new ArrayList<Tegla>();
		this.trnOpt = 0.0;
	}
	

	public String 		proizv() 		{ return proizv; 		}
	public int 			brjRed() 		{ return brjRed; 		}
	public double 		maxOpt() 		{ return maxOpt; 		}
	
	public List<Tegla> 	tegle()  		{ return tegle;  		}
	public Tegla 		tegla(int i)  	{ return tegle.get(i);  }
	public int 			brjTgl() 		{ return tegle.size();	}
	public double 		trnOpt() 		{ return trnOpt; 		}
	
	
	public String toString() {
		return String.format(
				"%-15s [ %.1f / %.1f kg, ukupna zapremina %.1f l ]\n", 
				proizv, trnOpt, maxOpt, ukupnaZapremina());
	}
	
	public void print() {
		
		System.out.println(this);
		for (Tegla t : tegle) System.out.println("\t" + t);
	}
	
	
	public boolean setTrnOpt(double opt) {
		
		if (opt > this.maxOpt)
			return false;
		
		this.trnOpt = opt;
		return true;
	}	
	
	public boolean addOpt(double opt) {
		
		if (this.trnOpt + opt > this.maxOpt)
			return false;
		
		this.trnOpt += opt;
		return true;
	}
	
	
	protected boolean moguDaDodam(Tegla t) {
		
		return this.trnOpt + t.tez() < this.maxOpt;
	}
	
	public boolean dodajTeglu(Tegla t) {
		
		if (!moguDaDodam(t))
			return false;
		
		tegle.add(t);
		addOpt(t.tez());
		
		return true;
	}
	
	
	public double ukupnaZapremina() {
		
		double sum = 0.0;
		
		for (Tegla t : tegle)
			sum += t.zap();
		
		return sum;
	}
	
	
	public static String materijal(String proizv) {
		if (proizv.length() > 5)
			return "plastika";
		else
			return "drugo";
	}
}
