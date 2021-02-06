package abc191.C;

import java.util.*;

public class Main {

	static int h; // 盤面の縦サイズ
	static int w; // 盤面の横サイズ
	static boolean[][] f; // 各マスは通行可能か
	static boolean[][] asi; // 各マスは未到達か

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		h = Integer.parseInt(sc.next());
		w = Integer.parseInt(sc.next());
		f = new boolean[h][w];
		asi = new boolean[h][w];
		int i;
		int j;
		int starti = -1;
		int startj = -1;
		for (i = 0; i < h; i++) {
			String line = sc.next();
			for (j = 0; j < w; j++) {
				f[i][j] = line.charAt(j) != '.' ? true : false;
				asi[i][j] = f[i][j];
				if (f[i][j] && starti == -1) {
					starti = i;
					startj = j;
				}
			}
		}

		// コーナーケース
		if (!f[starti + 1][startj] && !f[starti][startj + 1]) {
			System.out.println(4);
			return;
		}

		// スタート地点
		i = starti;
		j = startj;
		int face = 0;
		int furi = 0;

		// 左手を壁につけて一周
		while (true) {

			// 確認用
			// System.out.println(i + "_" + j + " " + face + " " + furi);

			if (face == 0) {
				if (f[i][j - 1]) {
					face = 3;
					j--;
					furi++;
				} else if (f[i - 1][j]) {
					i--;
				} else if (f[i][j + 1]) {
					face = 1;
					j++;
					furi++;
				} else {
					face = 2;
					i++;
					furi += 2;
				}
			} else if (face == 1) {
				if (f[i - 1][j]) {
					face = 0;
					i--;
					furi++;
				} else if (f[i][j + 1]) {
					j++;
				} else if (f[i + 1][j]) {
					face = 2;
					i++;
					furi++;
				} else {
					face = 3;
					j--;
					furi += 2;
				}
			} else if (face == 2) {
				if (f[i][j + 1]) {
					face = 1;
					j++;
					furi++;
				} else if (f[i + 1][j]) {
					i++;
				} else if (f[i][j - 1]) {
					face = 3;
					j--;
					furi++;
				} else {
					face = 0;
					i--;
					furi += 2;
				}
			} else if (face == 3) {
				if (f[i + 1][j]) {
					face = 2;
					i++;
					furi++;
				} else if (f[i][j - 1]) {
					j--;
				} else if (f[i - 1][j]) {
					face = 0;
					i--;
					furi++;
				} else {
					face = 1;
					j++;
					furi += 2;
				}
			}

			asi[i][j] = false;

			// スタート地点に帰ってきたら
			if (i == starti && j == startj) {

				if (f[starti + 1][startj] && f[starti][startj + 1] && face == 3) {
					// 続行
				} else {
					// 終了
					if (face == 3) {
						System.out.println(furi + 1);
					} else if (face == 0) {
						System.out.println(furi);
					}
					break;
				}
			}

		}

	}
}
