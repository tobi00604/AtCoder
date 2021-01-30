package abc045.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String strA = sc.next();
		String strB = sc.next();
		String strC = sc.next();

		int a = 0;
		int b = 0;
		int c = 0;
		char now = 'a';
		while (true) {

			// System.out.println(now + " " + a + " " + b + " " + c);

			if (now == 'a') {
				if (a == strA.length()) {
					System.out.println("A");
					return;
				}
				now = strA.charAt(a);
				a++;
			} else if (now == 'b') {
				if (b == strB.length()) {
					System.out.println("B");
					return;
				}
				now = strB.charAt(b);
				b++;
			} else if (now == 'c') {
				if (c == strC.length()) {
					System.out.println("C");
					return;
				}
				now = strC.charAt(c);
				c++;
			}

		}

	}
}
