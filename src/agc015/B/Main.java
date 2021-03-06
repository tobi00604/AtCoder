package agc015.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		boolean[] a = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.charAt(i) == 'U';
		}

		long result = 0;

		// 各階
		for (int i = 0; i < n; i++) {

			// ここから上にある階数
			int up = n - i - 1;
			// ここから下にある階数
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
