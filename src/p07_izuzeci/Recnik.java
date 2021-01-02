package p07_izuzeci;

import java.util.HashMap;
import java.util.LinkedList;

public class Recnik {

	// mapa koja neku rec slika u sve njene prevode
	private HashMap<String, LinkedList<String>> r = new HashMap<String, LinkedList<String>>();
	
	public void dodajSaGreskom(String orig, String prevod) {
		LinkedList<String> prevodi = r.get(orig);
		prevodi.add(prevod);								// null pointer exception!
	}
	
	public void dodaj(String orig, String prevod) {
		LinkedList<String> prevodi = r.get(orig);
		if (prevodi == null) {
			prevodi = new LinkedList<String>();
			r.put(orig, prevodi);
		}
		
		prevodi.add(prevod);
	}
	
	// neproveravani izuzeci (bagovi)
	public static void main(String[] args) {
		
		Recnik r = new Recnik();
		r.dodajSaGreskom("programiranje", "programming");	// null pointer exception
		r.dodajSaGreskom("programiranje", "programming");
	}
}
