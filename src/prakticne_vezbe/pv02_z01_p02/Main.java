package prakticne_vezbe.pv02_z01_p02;

import java.io.IOException;

public class Main {

public static void main(String[] args) throws NumberFormatException, IOException {
		
		SkolaJezika sk = SkolaJezika.load("kursevi");
		sk.print();
		
		System.out.printf("\nNapredni kurs sa najvise polaznika: %s.\n", sk.najnaprednijiJezik());
		System.out.println();
		
		sk.unaprediGrupu("engleski", "srednji");
		System.out.println();
	}
}
