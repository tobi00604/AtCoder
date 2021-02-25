package abc070.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			b[i] = Long.parseLong(sc.next());
		}

		System.out.println(lcm(b));

	}

	// 2‚Â‚Ì”‚ÌÅ‘åŒö–ñ”‚ð•Ô‚·
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// 2‚Â‚Ì”‚ÌÅ¬Œö”{”‚ð•Ô‚·
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}

	// ”z—ña‚ÌŠe—v‘f‚ÌÅ¬Œö”{”‚ð•Ô‚·
	static long lcm(long[] a) {
		long result = a[0];
		for (int i = 0; i < a.length; i++) {
			result = lcm(result, a[i]);
		}
		return result;
	}
}
