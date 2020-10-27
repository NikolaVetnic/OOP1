package tv02_z05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class Generacija {
	
	private Student[] studenti;
	
	private Generacija(String inputFile) throws IOException {
		
		BufferedReader br = new BufferedReader(
				new FileReader(inputFile));
		
		int brStudenata = Integer.parseInt(br.readLine());
		studenti = new Student[brStudenata];
		
		for (int i = 0; i < brStudenata; i++) {
			
			String line = br.readLine();
			
			studenti[i] = Student.novi(
									   line.split(",")[0].trim(),
					Double.parseDouble(line.split(",")[1].trim()),
									   line.split(",")[2].trim());
		}
		
		br.close();
	}
	
	public static Generacija ucitaj(String imeFajla) throws IOException {
		return new Generacija(imeFajla);
	}

	public void nagrade(String departman) {
		
		int count = 0;
		
		Consumer<String> prnNagradjeni = a -> System.out.println("Nagradjeni studenti na " + a);
		prnNagradjeni.accept(departman);
		
		for (Student s : studenti)
			if (s.departman().compareTo(departman) == 0)
				if (s.dobijaNagradu()) {
					System.out.println(s);
					count++;
				}
		
		System.out.println("Ukupno nagrada: " + count);
	}
	
	public Student najboljiNaDepartmanu(String departman) {
		
		Student najbolji = studenti[0];
		KomparatorPoProseku k = new KomparatorPoProseku();
		
		for (Student s : studenti)
			if (s.departman().compareTo(departman) == 0)
				if (k.compare(s, najbolji) != -1)
					najbolji = s;
		
		return najbolji;
	}
}
