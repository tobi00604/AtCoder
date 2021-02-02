package abc152.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int max = Integer.parseInt(sc.next());

		// 81通りを先に調べて対応表を作ってしまう
		int[][] table = new int[10][10];
		for (int a = 1; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {

				// 1以上max以下の整数で、bで始まってaで終わるものはいくつあるか
				// ※このループが重いのでTLEになるかもしれない
				for (int i = 1; i <= max; i++) {
					if (left(i) == b && right(i) == a) {
						table[a][b]++;
					}
				}

				// 確認用
				// System.out.print(table[a][b] + " ");
			}
			// System.out.println();
		}

		// 対応表を使って答えを出す
		int result = 0;
		for (int i = 1; i <= max; i++) {
			result += table[left(i)][right(i)];
		}
		System.out.println(result);
	}

	// 与えられた整数の左端桁を返す（例：314だったら3）
	static int left(int n) {
		return String.valueOf(n).charAt(0) - 48;
	}

	// 与えられた整数の右端桁を返す（例：314だったら4）
	static int right(int n) {
		return n % 10;
	}
}
