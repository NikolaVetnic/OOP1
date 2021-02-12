package usmeni_ispit.qB36_obrada_dogadjaja;

public class Q36a {
	
	interface FI {
		int operation(int a, int b);
	}
	
	private static int operate(int a, int b, FI fi) {
		return fi.operation(a, b);
	}
	
	public static void main(String[] args) {
		
		FI add = (int a, int b) -> a + b;
		System.out.println(operate(1, 14, add));
	}
}
