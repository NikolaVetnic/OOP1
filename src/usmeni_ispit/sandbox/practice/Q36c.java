package usmeni_ispit.sandbox.practice;

public class Q36c {

	interface FI {
		void uvecaj(int x);
	}
	
	public static void main(String[] args) {
		
		FI fi = (int x) -> System.out.println(x + 10);
		fi.uvecaj(5);
	}
}
