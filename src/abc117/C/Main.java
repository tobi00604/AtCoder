package abc117.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] x = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(x);

		// コーナーケース 駒を置くだけでゲームが終わる場合
		if (m <= n) {
			System.out.println(0);
			return;
		}

		// 各区間の長さを計測
		int[] dist = new int[m - 1];
		for (int i = 0; i < m - 1; i++) {
			dist[i] = x[i + 1] - x[i];
		}
		Arrays.sort(dist);

		// n個の駒があるので n-1 ヶ所の区間は通らなくていい
		int result = 0;
		for (int i = 0; i < m - 1 - (n - 1); i++) {
			result += dist[i];
		}
		System.out.println(result);

	}
}
