package usmeni_ispit.qA17b_shadowing_polja;

public class Q17b {

	class A {
		int x = 10;
		class B {
			int x = 20;
			class C {
				void stampaj() {
					System.out.println(A.this.x + B.this.x);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Q17b q = new Q17b();
		A a = q.new A();
		A.B b = a.new B();
		A.B.C c = b.new C();
		
		c.stampaj();
	}
}
