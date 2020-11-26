package pv02_z02_p02;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Forum f = Forum.ucitaj("objave");
		
		f.print();
		System.out.println();
		
		f.najpopularnijaObjava("sport");
		f.najpopularnijaObjava("hobiji");
		f.najpopularnijaObjava("muzika");
		f.najpopularnijaObjava("slikarstvo");
		System.out.println();
		
		f.statistika();
	}
}
