package agc015.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		boolean[] a = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.charAt(i) == 'U';
		}

		long result = 0;

		// ŠeŠK
		for (int i = 0; i < n; i++) {

			// ‚±‚±‚©‚çã‚É‚ ‚éŠK”
			int up = n - i - 1;
			// ‚±‚±‚©‚ç‰º‚É‚ ‚éŠK”
			int down = i;

			if (a[i]) {
				result += up;
				result += down * 2;
			} else {
				result += up * 2;
				result += down;
			}

		}
		System.out.println(result);

	}
}
