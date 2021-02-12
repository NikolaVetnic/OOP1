package usmeni_ispit.qA14_staticki_inicijalizatori;

public class Q14 {

	static int[] a;
	
	static {
		a = new int[20];
		
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] = i * i);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Sad tek krecemo...");
	}
}
