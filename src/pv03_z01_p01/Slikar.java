package pv03_z01_p01;

public class Slikar extends Umetnik {

	
	public Slikar(String ime, UmetnickoDelo[] dela) {
		super(ime, dela, 5);
	}


	public Slikar(String ime) {
		super(ime, 5);
	}
	
	
	@Override
	public double vrednost() {
		
		double sum = 0.0;
		
		for (UmetnickoDelo d : dela()) {
			
			double currentSum = d.cena();
			int razlikaGodina = Umetnik.TRENUTNA_GODINA - d.god();
			
			for (int i = 0; i < razlikaGodina; i++)
				currentSum += currentSum * 0.15;
			
			sum += currentSum;
		}
		
		System.out.printf("Cena svih izlozenih dela slikara %s je: %.2f EUR", ime(), sum);
		return sum;
	}
}
