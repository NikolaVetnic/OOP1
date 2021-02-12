package prakticne_vezbe.pv04_z02.dom2b;

import java.util.LinkedList;

public abstract class TajniAgent {

	private String kodnoIme;
	private boolean primioInformaciju;
	protected boolean prosledioInformaciju = false;
	
	protected LinkedList<TajniAgent> kontakti = new LinkedList<TajniAgent>();
	protected LinkedList<TajniAgent> prosledjivani = new LinkedList<TajniAgent>();
	
	public TajniAgent(String kodnoIme) {
		this.kodnoIme = kodnoIme;
	}
	
	public void dodajKontakt(TajniAgent kontakt) {
		kontakti.add(kontakt);
	}
	
	// nikad ne prosledjuje agentu kojem je vec prosledjivao
	public void primiInformaciju(TajniAgent izvor) {
		
		if (izvor != null && izvor.prosledjivao(this))	// da li smo na pocetku propagacije
			return;										// ako nismo, da li je prosledjivano ovom agentu
		
		System.out.println(izvor + " -> " + this);
		primioInformaciju = true;
		
		if (izvor != null)								// da li smo na pocetku propagacije
			izvor.prosledjivani.add(this);				// ako nismo, dodaj agenta u listu prosledjivanih
		
		proslediInformaciju(izvor);
	}
	
	private boolean prosledjivao(TajniAgent a0) {
		
		for (TajniAgent a1 : prosledjivani)
			if (a1.kodnoIme().equals(a0.kodnoIme()))
				return true;
		
		return false;
	}
	
	public abstract void proslediInformaciju(TajniAgent izvor);
	
	public String kodnoIme()			{ return kodnoIme;			}
	public boolean primioInformaciju() 	{ return primioInformaciju; }
	public String toString()			{ return kodnoIme;			}
}