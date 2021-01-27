package usmeni_ispit.qB31_balansirane_zagrade;

import java.util.Stack;

public class Main {
	
	
	private static boolean kompatibilna(char z1, char z2) {
		if (z1 == '{') 		return z2 == '}';
		else if (z1 == '[') return z2 == ']';
		else 				return z2 == ')'; 
	}
	
	
	public static StringBuilder uvuci(int level) {
		
		StringBuilder sb = new StringBuilder();
		sb.append('\n');
		
		for (int i = 0; i < level; i++) sb.append("  ");
		
		return sb;
	}
	
	
	public static String format(String ulaz) throws NepravilneZagrade {
		
		Stack<Zagrada> stek = new Stack<Zagrada>();
		StringBuilder sb = new StringBuilder();
		int level = 0;
		
		for (int i = 0; i < ulaz.length(); i++) {
			
			char c = ulaz.charAt(i);
			
			if (c == '(' || c == '[' || c == '{') {
				
				stek.push(new Zagrada(c, i));
				++level;
				sb.append(uvuci(level));
			} else if (c == ')' || c == ']' || c== '}') {
				
				if (stek.empty())
					throw new ZatvorenaViseca(new Zagrada(c, i));
				
				Zagrada poslednjaOtvorena = stek.pop();
				
				if (!kompatibilna(poslednjaOtvorena.getZagrada(), c))
					throw new ZatvorenaPogresna(poslednjaOtvorena, new Zagrada(c, i));
				
				level--;
			} else {
				sb.append(c);
			}
		}
		
		if (!stek.empty())
			throw new OtvorenaViseca(stek.pop());
		
		return sb.toString();
	}
	

	public static void main(String[] args) {
		
		String[] testSlucajevi = {
			"if [<= n 1] {1} (* {n}, (factorial (-n 1)))",
			"Neke ([]{ } zagrade)])))",
			"Ot ((( nema zatvorene",
			"Zdravko{Zdr(av)ko[dren]]"
		};
		
		int brZatvorenaPogresna = 0, brViseca = 0, ok = 0;
		
		for (int i = 0; i < testSlucajevi.length; i++) {
			
			try {
				System.out.println(format(testSlucajevi[i]));
				ok++;
			} catch (NepravilneZagrade e) {
				System.err.println(e.getMessage());
				
				if (e instanceof ZatvorenaPogresna)
					brZatvorenaPogresna++;
				else
					brViseca++;
			}
		}
		
		System.out.println("Proslo test primera: " + ok);
		System.out.println("Zatvoreno pogresnih: " + brZatvorenaPogresna);
		System.out.println("Visecih	           : " + brViseca);
	}
}
