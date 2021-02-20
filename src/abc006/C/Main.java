package abc006.C;

import java.util.*;

// ‰ğà‚ğ“Ç‚ñ‚Å‚©‚ç‚â‚Á‚Ä‚İ‚½
public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		if (m == 0) {
			System.out.println("0 0 0");
			return;
		}

		if (m == 1) {
			System.out.println("-1 -1 -1");
			return;
		}

		int b = (m % 2 == 1) ? 1 : 0;

		for (int a = 0; a <= 100000; a++) {
			if (2 * a + 3 * b + 4 * (n - a - b) == m && a + b <= n) {
				System.out.println(a + " " + b + " " + (n - a - b));
				return;
			}
		}
		System.out.println("-1 -1 -1");
	}
}
