package pv02_z02_p01;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Forum f = Forum.ucitaj("res//objave.txt");
		f.stampaj();		System.out.println();
		
		String tema;
		
		tema = "sport";
		System.out.println("Najpopularnija objava u temi '" + tema + "': " + f.najpopularnijaObjava(tema));
		
		tema = "strani jezici";
		System.out.println("Najpopularnija objava u temi '" + tema + "': " + f.najpopularnijaObjava(tema));
		
		tema = "aaa";
		f.najpopularnijaObjava(tema);
		
		System.out.println();
		
		f.statistika();		System.out.println();
	}
}
