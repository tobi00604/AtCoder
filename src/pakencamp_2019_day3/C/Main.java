package pakencamp_2019_day3.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(sc.next());
			}
		}

		// 問題サイズが小さいので全探索してみる
		long result = 0;
		for (int one = 0; one < m; one++) {
			for (int two = one+1; two < m; two++) {
				long total = 0;
				for (int i = 0; i < n; i++) {
					total += Math.max(a[i][one], a[i][two]);
				}
				result = Math.max(result, total);
			}
		}

		System.out.println(result);
	}
}
