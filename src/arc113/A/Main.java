package arc113.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());

		long result = 0;
		for (int a = 1; a * a * a <= k; a++) {
			for (int b = a; b * b <= k / a; b++) {
				for (int c = b; a * b * c <= k; c++) {
					result += f(a, b, c);
				}
			}
		}
		System.out.println(result);

	}

	static long f(int a, int b, int c) {
		if (a == b && b == c) {
			return 1;
		} else if (a == b || b == c || c == a) {
			return 3;
		}
		return 6;
	}
}
