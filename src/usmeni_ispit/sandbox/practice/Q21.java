package usmeni_ispit.sandbox.practice;

public class Q21 {

	enum Kvadrat {
		JEDAN(1),
		DVA(2),
		TRI(3),
		CETIRI(4);
		
		int i;
		
		private Kvadrat(int i) {
			this.i = i;
		}
		
		public int kvadrat() { return i * i; }
	}
	
	public static void main(String[] args) {
		
		Kvadrat[] kvadrati = Kvadrat.values();
		
		for (int i = 0; i < kvadrati.length; i++)
			System.out.println(kvadrati[i].kvadrat());
	}
}
