package usmeni_ispit.qA16_staticke_ugnjezdene;

public class Q16 {

	class A {
		
		class B extends A {
			
			public B(String s) {
				super(s);
			}
			
			public String s() { return this.s; }
		}
		
		String s;
		
		public A(String s) {
			this.s = s;
		}
	}
	
	public static void main(String[] args) {
		
		Q16 q16 = new Q16();
		Q16.A a = q16.new A("Evo ga A...");
		Q16.A.B b = a.new B("Evo ga i B...");
		
		System.out.println(a.s);
		System.out.println(b.s());
	}
}
