package usmeni_ispit.qA19_interfejsi;

interface IA {
	
	void printIA();
}

interface IB extends IA {
	
	void printIB();
}

public class NasledjivanjeInterfejsa implements IB {

	@Override
	public void printIA() {
		System.out.println("KlasaC_printIA");
	}

	@Override
	public void printIB() {
		System.out.println("KlasaC_printIB");
	}
	
	public static void main(String[] args) {
		
		NasledjivanjeInterfejsa kc = new NasledjivanjeInterfejsa();
		kc.printIA();
		kc.printIB();
	}
}
