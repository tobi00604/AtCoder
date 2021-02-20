package abc075.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		boolean[][] f = new boolean[h + 2][w + 2];
		int[][] p = new int[h + 2][w + 2];
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				f[i + 1][j + 1] = str.charAt(j) == '#';
				p[i + 1][j + 1] = 0;
			}
		}

		// マインスイーパの各爆弾について周囲に数を与える
		for (int i = 1; i < h + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (f[i][j]) {
					p[i - 1][j - 1]++;
					p[i - 1][j]++;
					p[i - 1][j + 1]++;
					p[i][j - 1]++;
					p[i][j + 1]++;
					p[i + 1][j - 1]++;
					p[i + 1][j]++;
					p[i + 1][j + 1]++;
				}
			}
		}

		// 出力
		for (int i = 1; i < h + 1; i++) {
			String str = "";
			for (int j = 1; j < w + 1; j++) {
				str += f[i][j] ? "#" : p[i][j];
			}
			System.out.println(str);
		}

	}

}
