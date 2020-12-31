package hhkb2020.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = Integer.valueOf(sc.next());
		int w = Integer.valueOf(sc.next());
		boolean[][] a = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				a[i][j] = line.substring(j, j + 1).equals(".");
			}
		}

		long result = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {

				// System.out.println(i + " " + h + " " + j + " " + w);

				if (i != h - 1 && a[i][j] && a[i + 1][j]) {
					result++;
				}

				if (j != w - 1 && a[i][j] && a[i][j + 1]) {
					result++;
				}
			}
		}

		System.out.println(result);

	}
}
