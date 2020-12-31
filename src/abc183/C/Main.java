package abc183.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int t[][] = new int[8][8];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				t[i][j] = Integer.parseInt(sc.next());
			}
		}

		// 確認用
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println("");
		}

		// 問題のサイズ的に全探索（つまりＯ(n!)のアルゴリズム）でよさそうだけど
		// 順列の列挙（4桁だったら1234, 1243, 1324, 1342, …の 4! 通り）を
		// うまく実装できなくて時間切れ。
		// ルンルンナンバーっぽく再帰関数か？

	}
}
