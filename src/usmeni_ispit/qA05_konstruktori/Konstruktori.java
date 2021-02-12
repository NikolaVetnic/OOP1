package usmeni_ispit.qA05_konstruktori;

public class Konstruktori {

	class KlasaA {
		
		private class KlasaC extends KlasaA {
			
			public KlasaC(int a) {
				super(a);
			}
		}
		
		private int a;
		
		public KlasaA(int a) {
			this.a = a;
		}
		
		public int a()		{ return a; }
		
		private void m() 	{ System.out.println(a); }
	}
}
