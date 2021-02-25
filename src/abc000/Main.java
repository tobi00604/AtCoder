package abc000;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long m = Long.parseLong(sc.next());
		String s = sc.next();

		int[] a = new int[n];
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Long.parseLong(sc.next());
		}

		// '.'‚Æ'#'‚Ì”Õ–Ê“ü—Í
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		boolean[][] f = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = (str.charAt(j) == '.') ? true : false;
			}
		}

	}
}
