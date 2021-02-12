package prakticne_vezbe.pv01_z02_p02;

public class Tim {

	Kosarkas[] kosarkasi;
	
	public Tim(Kosarkas[] kosarkasi) {
		this.kosarkasi = kosarkasi;
	}
	
	public String toString() {
		
		String out = "";
		
		for (Kosarkas k : kosarkasi)
			out += k + " ";
		
		return out;
	}
	
	public void print() {
		
		for (Kosarkas k : kosarkasi)
			System.out.println(k);
	}
	
	public String najkorisnijiIgracNaTerenu() {
		
		Kosarkas out = kosarkasi[0];
		
		for (Kosarkas k : kosarkasi)
			if (k.kor() > out.kor())
				out = k;
		
		return out.ime();
	}
}
