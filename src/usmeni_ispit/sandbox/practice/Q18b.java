package usmeni_ispit.sandbox.practice;

public class Q18b {

	interface Zivotinja {
		void krikni();
	}
	
	public static void main(String[] args) {
	
		Zivotinja svinja = new Zivotinja() {
			public void krikni() { System.out.println("Oink!"); }
		};
		
		svinja.krikni();
	}
}
