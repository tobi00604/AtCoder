package abc096.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		boolean[][] f = new boolean[h + 2][w + 2];
		for (int i = 0; i < h + 2; i++) {
			for (int j = 0; j < w + 2; j++) {
				f[i][j] = false;
			}
		}
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				f[i + 1][j + 1] = (str.charAt(j) == '.') ? false : true;
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (f[i][j]) {
					if (!f[i - 1][j] && !f[i + 1][j] && !f[i][j - 1] && !f[i][j + 1]) {
						System.out.println("No");
						return;
					}
				}
			}
		}
		System.out.println("Yes");

	}
}
