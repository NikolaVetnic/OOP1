package pv02_z01_p01;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		SkolaJezika sk = SkolaJezika.load("kursevi");
		sk.print();
		
		System.out.println("\nNapredni kurs sa najvise polaznika:\n" + sk.najnaprednijiKurs());
		System.out.println();
		
		sk.unaprediGrupu("engleski", "srednji");
		System.out.println();
		
		sk.print();
	}
}
