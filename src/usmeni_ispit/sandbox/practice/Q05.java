package usmeni_ispit.sandbox.practice;

public class Q05 {

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
	}
}
