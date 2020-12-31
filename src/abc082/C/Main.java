package abc082.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long a[];
		a = new long[100001];

		int result = 0;
		for (int i = 0; i < n; i++) {
			long x = Long.parseLong(sc.next());

			if (x >= 100001) {
				result++;
			} else {
				if (a[(int) x] == x) {
					result++;
				} else {
					a[(int) x]++;
				}
			}
		}

		for (int i = 1; i <= 100000; i++) {
			if (a[i] != 0 && a[i] != i) {
				result += a[i];
			}
		}

		System.out.println(result);

	}
}
