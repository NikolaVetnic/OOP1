package usmeni_ispit.qA17a_unutrasnje_klase;

public class Outer {

	class Inner {
		
		private int x;
		
		public Inner(int x) {
			this.x = x;
		}
	}
	
	private Inner in;
	
	public Outer() {
		this.in = new Inner(4);
	}
	
	public static void main(String[] args) {
		
		Outer out = new Outer();
		Outer.Inner oi = out.new Inner(2);
	}
}
