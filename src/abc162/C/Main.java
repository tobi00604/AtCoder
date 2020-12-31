package abc162.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int i;
		int j;
		int k;
		long sum = 0;
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				for (k = 1; k <= n; k++) {
					sum += gcd(gcd(i,j),k);
				}

			}

		}

		System.out.println(sum);

	}

	public static int gcd(int m, int n) {
		int r;
		while (n > 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
}
