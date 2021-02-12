package usmeni_ispit.qB36_obrada_dogadjaja;

public class Q36c {

	interface FI {
		void uvecaj(int x);
	}
	
	public static void main(String[] args) {
		
		FI fi = (int x) -> System.out.println(x + 10);
		fi.uvecaj(5);
	}
}
