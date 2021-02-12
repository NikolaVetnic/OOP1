package usmeni_ispit.qB31_Practice;

import java.util.Stack;

public class Main {

	private static boolean kompatibilne(char c1, char c2) {
		if		(c1 == '{') return c2 == '}';
		else if	(c1 == '[') return c2 == ']';
		else				return c2 == ')';
	}
	
	private static StringBuilder format(int level) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		
		for (int i = 0; i < level; i++) sb.append("  ");
		
		return sb;
	}
	
	public static String format(String ulaz) throws NepravilneZagrade {
		
		Stack<Zagrada> s = new Stack<Zagrada>();
		StringBuilder sb = new StringBuilder();
		int level = 0;
		
		for (int i = 0; i < ulaz.length(); i++) {
			
			char c = ulaz.charAt(i);
			
			if (c == '{' || c == '[' || c == '(') {
				s.push(new Zagrada(c, i));
				++level;
				sb.append(format(level));
			} else if (c == '}' || c == ']' || c == ')') {
				if (s.empty())
					throw new ZatvorenaViseca(new Zagrada(c, i));
				
				Zagrada poslednjaOtvorena = s.pop();
				
				if (!kompatibilne(poslednjaOtvorena.zag, c))
					throw new ZatvorenaPogresna(poslednjaOtvorena, new Zagrada(c, i));
				
				--level;
			} else {
				sb.append(c);
			}
		}
		
		if (!s.empty())
			throw new OtvorenaViseca(s.pop());
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String[] ulaz = {
				"if [<= n 1] {1} (* {n}, (factorial (-n 1)))",
				"Neke ([]{ } zagrade)])))",
				"Ot ((( nema zatvorene",
				"Zdravko{Zdr(av)ko[dren]]"
		};
		
		int brVisecih 				= 0,
			brZatvorenihPogresno 	= 0,
			ok						= 0;
		
		for (String s : ulaz) {
			try {
				System.out.println(format(s));
				ok++;
			} catch (NepravilneZagrade e) {
				System.err.println(e.getMessage());
				
				if (e instanceof ZatvorenaPogresna)
					brZatvorenihPogresno++;
				else
					brVisecih++;
			}
		}
	}
}
