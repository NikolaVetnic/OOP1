package usmeni_ispit.qA12_apstraktne_klase;

public class Q12 {

	static abstract class Zivotinja {
		abstract String zvuk();
	}
	
	static class Macak extends Zivotinja {
		@Override
		public String zvuk() {
			return "Mjau!";
		}
	}
	
	public static void main(String[] args) {
		
		Zivotinja z = new Macak();
		System.out.println(z.zvuk());
	}
}
