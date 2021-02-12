package usmeni_ispit.sandbox.practice;

public class Q18a {

	public static void main(String[] args) {
		
		class Zbir { 
			int a, b;
			
			public Zbir(int a, int b) {
				this.a = a; this.b = b;
			}
			
			int zbir() { return a + b; }
		}
		
		Zbir z = new Zbir(2, 2);
		System.out.println(z.zbir());
	}
}
