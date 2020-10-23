package pv01_z01;

public class Main {

	public static void main(String[] args) {
		
		Kazino kazino = new Kazino(
				new Kladionicar[] {
						new Kladionicar("Pera", "poker", 15000),
						new Kladionicar("Mika", "ajnc", 17000),
						new Kladionicar("Zika", "rulet", -1500),
						new Kladionicar("Bora", "ajnc", -11000),
						new Kladionicar("Dora", "rulet", 5000),
						new Kladionicar("Zora", "ajnc", -3000),
						new Kladionicar("Lara", "poker", 22000),
						new Kladionicar("Mara", "poker", 7000)
				});
		
		System.out.println(kazino);
		
		System.out.println(kazino.najprofitabilnijaIgra());
	}
}
