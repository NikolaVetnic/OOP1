package usmeni_ispit.sandbox;

public class Practice {
	
	public static void main(String[] args) {
		
		class Zbir {
			int a, b;
			
			public Zbir(int a, int b) {
				this.a = a;
				this.b = b;
			}
			
			public void zbir() { System.out.println(a + b); }
		}
		
		Zbir z = new Zbir(1, 2);
		z.zbir();
	}
}
