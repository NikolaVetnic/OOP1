package usmeni_ispit.qA19_interfejsi;

public class TestFuncInt {
	
	interface FI {
		int operation(int a, int b);
	}
	
	private static int operate(int a, int b, FI fi) {
		return fi.operation(a, b);
	}
	
	public static void main(String[] args) {
		
		FI add = (int a, int b) -> a + b;
		System.out.println(operate(3, 4, add));
		
		FI mul = (int a, int b) -> a * b;
		System.out.println(operate(3, 4, mul));
	}
}
