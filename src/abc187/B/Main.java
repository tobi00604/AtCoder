package abc187.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		double[] x = new double[n];
		double[] y = new double[n];

		for (int i = 0; i < n; i++) {
			x[i] = (float) Integer.parseInt(sc.next()) + 0.0;
			y[i] = (float) Integer.parseInt(sc.next()) + 0.0;
		}

		// 点iと点jのペアを全探索
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// ２点が縦に並んでいたらスキップしてよい
				if (x[i] == x[j]) {
					continue;
				}

				// ２点の傾きを確認
				double k = (y[j] - y[i]) / (x[j] - x[i]);
				if (-1.0 <= k && k <= 1.0) {
					result++;
				}

			}
		}

		System.out.println(result);

	}
}
