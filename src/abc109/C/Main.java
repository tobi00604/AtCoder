package abc109.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
		}

		int[] d = new int[n];
		d[0] = Math.abs(p[0] - x);
		for (int i = 1; i < n; i++) {
			d[i] = Math.abs(p[i] - p[i - 1]);
		}

		// d[0]`d[n-1]‚ÌÅ‘åŒö–ñ”
		long result = d[0];
		for (int i = 0; i < n; i++) {
			result = gcd(result, (long) d[i]);
		}
		System.out.println(result);
	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
