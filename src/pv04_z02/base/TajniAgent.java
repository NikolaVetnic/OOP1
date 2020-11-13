package pv04_z02.base;

import java.util.LinkedList;

public abstract class TajniAgent {

	private String kodnoIme;
	private boolean primioInformaciju;
	protected LinkedList<TajniAgent> kontakti = new LinkedList<TajniAgent>();
	
	public TajniAgent(String kodnoIme) {
		this.kodnoIme = kodnoIme;
	}
	
	public void dodajKontakt(TajniAgent kontakt) {
		kontakti.add(kontakt);
	}
	
	public void primiInformaciju(TajniAgent izvor) {
		
		System.out.println(izvor + " -> " + this);
		primioInformaciju = true;
		
		proslediInformaciju(izvor);
	}
	
	public abstract void proslediInformaciju(TajniAgent izvor);
	
	public String kodnoIme()			{ return kodnoIme;			}
	public boolean primioInformaciju() 	{ return primioInformaciju; }
	public String toString()			{ return kodnoIme;			}
}