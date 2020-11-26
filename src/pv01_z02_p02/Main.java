package pv01_z02_p02;

public class Main {

	public static void main(String[] args) {
		
		Tim tim = new Tim(
				new Kosarkas[] {
						new Kosarkas("Travolta iz Borce Grede", "bek", 0.95),
						new Kosarkas("Kale Gospodar Vremena", "centar", 0.35),
						new Kosarkas("Stole Vole", "krilo", 0.15),
						new Kosarkas("Shaki iz Kikinde", "krilo", 1.00),
						new Kosarkas("Zeljko Malnar", "golman", 0.75),
				});
		
		tim.print();
		System.out.println();
		
		System.out.printf("Najkorisniji igrac je: %s.\n", tim.najkorisnijiIgracNaTerenu());
	}
}
