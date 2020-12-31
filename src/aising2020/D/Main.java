package aising2020.D;

import java.util.*;

// •’Ê‚É‘S’TõA‚½‚Ô‚ñTLE‚É‚È‚é
public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String baseStr = sc.next();

		for (int i = 1; i <= n; i++) {

			// ¶‚©‚çiƒrƒbƒg–Ú‚ğ”½“]‚µ‚Äsolve‚É“n‚·
			String str = baseStr;
			if (str.charAt(i - 1) == '0') {
				str = str.substring(0, i - 1) + '1' + str.substring(i, n);
			} else {
				str = str.substring(0, i - 1) + '0' + str.substring(i, n);
			}

			solve(str);
		}

	}

	public static void solve(String str) {
		int loop = 0;
		while (true) {
			loop++;
			int pop = pop(str);
			if (pop == 0) {
				System.out.println(loop);
				return;
			}
			int x = Integer.parseInt(str, 2) % pop;
			if (x == 0) {
				System.out.println(loop);
				return;
			}
			str = Integer.toBinaryString(x);
			str = String.format("%10s", str).replace(" ", "0");
		}
	}

	public static int pop(String str) {

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				result++;
			}
		}

		return result;
	}
}
