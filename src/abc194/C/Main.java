package abc194.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		long[] s = new long[n]; // —İÏ˜a
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
			s[i] = (i == 0) ? a[0] : s[i - 1] + a[i];
		}

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum1 += a[i] * a[i] * (n - 1);
		}
		for (int i = 1; i < n; i++) {
			sum2 += a[i] * s[i - 1];
		}

		System.out.println(sum1 - 2 * sum2);

	}
}
