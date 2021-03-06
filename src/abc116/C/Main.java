package abc116.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int h[] = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(sc.next());
		}

		// 配列h[]をすべて0にしていく作業
		int result = 0;
		while (true) {

			// 水やり範囲の左端を決める
			int start = 0;
			boolean finishFlg = true;
			for (start = 0; start < n; start++) {
				if (h[start] > 0) {
					finishFlg = false;
					break;
				}
			}

			// 作業終了判定
			if (finishFlg) {
				System.out.println(result);
				return;
			}

			// 水やり
			int end = 0;
			for (end = start; end < n; end++) {
				if (h[end] == 0) {
					break;
				}
				h[end]--;
			}

			result++;
		}
	}
}
