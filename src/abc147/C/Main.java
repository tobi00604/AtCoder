package abc147.C;

import java.util.*;

// ちょっと改良
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[][] info = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(info[i], 0);
			int m = Integer.parseInt(sc.next());
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(sc.next()) - 1;
				info[i][x] = (Integer.parseInt(sc.next()) == 1) ? 1 : -1;
			}
		}

		// 確認用
		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(info[i]));
		}

		// bit全探索
		int highScore = 0;
		for (int i = 0; i < (1 << n); i++) {

			// 仮定を作る
			boolean[] katei = new boolean[n];
			for (int j = 0; j < n; j++) {
				if ((1 & i >> j) == 1) {
					katei[j] = true;
				}
			}
//			System.out.println("今回の仮定 " + Arrays.toString(katei));

			// 仮定が矛盾してないか確認
			boolean ok = true;
			for (int j = 0; j < n; j++) {
				if (katei[j]) {
					for (int k = 0; k < n; k++) {
						if (j != k) {
							if (info[j][k] == 1 && katei[k] == false) {
//								System.out.println("矛盾A " + j + " " + k);
								ok = false;
							}
							if (info[j][k] == -1 && katei[k] == true) {
//								System.out.println("矛盾B " + j + " " + k);
								ok = false;
							}
						}
					}
				}
			}

			// 矛盾がなかったら、ハイスコア更新できるなら更新
			if (ok) {
				int score = 0;
				for (int j = 0; j < n; j++) {
					score += katei[j] ? 1 : 0;
				}
				highScore = Math.max(highScore, score);
//				System.out.println("現在のハイスコア " + highScore);
			}
		}

		// こたえ
		System.out.println(highScore);

	}
}
