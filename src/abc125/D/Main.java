package abc125.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// ‘«‚µŽZ‚µ‚Ä‚¢‚­
		long result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] < 0) {
				a[i] = -a[i];
				a[i + 1] = -a[i + 1];
			}
			result += a[i];
		}

		// ÅŒã‚Ì”‚ª³‚È‚çA‘«‚µŽZ‚µ‚ÄI—¹
		if (0 <= a[n - 1]) {
			System.out.println(result + a[n - 1]);
			return;
		}

		// ÅŒã‚Ì”‚ª•‰‚È‚çA‚»‚ê‚ð³‚É•Ï‚¦‚Ä‘«‚µ‚½‚ ‚ÆA
		// â‘Î’l‚ªÅ‚à¬‚³‚¢”‚ð’T‚µ‚Ä‚«‚Ä‚Q‰ñˆø‚­
		result += -a[n - 1];
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, Math.abs(a[i]));
		}
		System.out.println(result - min * 2);

	}
}
