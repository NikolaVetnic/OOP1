package usmeni_ispit.qA07_konstruktori_nasledjivanje;

public class Q07 {

	static class Pravougaonik {
		
		int a, b;
		
		public Pravougaonik(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int povrsina() { 
			return a * b; 
		}
		
		int uporedi(Pravougaonik q) {
			int d = this.povrsina() - q.povrsina();
			if 		(d > 0) return  1;
			else if (d < 0) return -1;
			else			return  0;
		}
	}
	
	static class Kvadrat extends Pravougaonik {
		
		public Kvadrat(int a) {
			super(a, a);
		}
	}
	
	public static void main(String[] args) {
		
		Pravougaonik p = new Pravougaonik(2, 3);
		System.out.println(p.povrsina());
		
		Kvadrat k = new Kvadrat(2);
		System.out.println(k.povrsina());
		
		System.out.println(p.uporedi(k));
	}
}
