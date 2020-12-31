package abc067.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long a[];
		a = new long[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
			sum += a[i];
		}

		long sum1 = 0;
		long sum2 = sum;
		long result = Math.abs(a[0] - (sum - a[0]));
		for (int i = 0; i < n - 1; i++) {
			sum1 += a[i];
			sum2 -= a[i];
			if (Math.abs(sum1 - sum2) < result) {
				result = Math.abs(sum1 - sum2);
			}
		}

		System.out.println(result);

	}
}
