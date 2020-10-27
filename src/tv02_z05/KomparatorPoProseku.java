package tv02_z05;

import java.util.Comparator;

public class KomparatorPoProseku implements Comparator<Student> {
	
	public int compare(Student a, Student b) {
		
		if (a.prosek() > b.prosek())
			return  1;
		else if (a.prosek() == b.prosek())
			return  0;
		else
			return -1;
	}

}
