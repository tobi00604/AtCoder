package abc118.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// “š‚¦
		System.out.println(gcd(a));

	}

	// 2‚Â‚Ì”‚ÌÅ‘åŒö–ñ”‚ð•Ô‚·
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// ”z—ña‚ÌŠe—v‘f‚ÌÅ‘åŒö–ñ”‚ð•Ô‚·
	static long gcd(int[] a) {
		long result = a[0];
		for (int i = 0; i < a.length; i++) {
			result = gcd(result, (long) a[i]);
		}
		return result;
	}
}
