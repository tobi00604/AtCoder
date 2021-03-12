package abc044.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// この問題特有の加工
		for (int i = 0; i < n; i++) {
			a[i] -= m;
		}
		m = 0;

		// 部分和問題（カードを一切選ばないという1通りを引いている）
		System.out.println(new Bubunwa(a).getCount(m) - 1);

	}

	// 部分和問題を解く
	static class Bubunwa {

		private int l = 0; // DPテーブルの左端、つまり作れる和の最小値（全カードの数字が非負なら0）
		private int r = 0; // DPテーブルの右端、つまり作れる和の最大値
		private long[] count; // count[i] := 狙った和を作る方法の数

		// コンストラクタ
		Bubunwa(int[] a) {

			int n = a.length; // カードの枚数
			l = 0; // DPテーブルの左端、つまり作れる和の最小値（全カードの数字が非負なら0）
			r = 0; // DPテーブルの右端、つまり作れる和の最大値
			for (int i = 0; i < n; i++) {
				if (a[i] < 0) {
					l += a[i];
				} else {
					r += a[i];
				}
			}

			// dp[i][j] := 最初のi枚のカードだけを使ってjを作る方法は何通りあるか
			long[][] dp = new long[n + 1][r - l + 1];
			dp[0][-l] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= (r - l); j++) {
					dp[i][j] = dp[i - 1][j];
					if (0 <= j - a[i - 1] && j - a[i - 1] <= r - l) {
						dp[i][j] += dp[i - 1][j - a[i - 1]];
					}
				}
			}

			// 結果まとめ
			count = new long[r - l + 1];
			for (int i = 0; i < r - l + 1; i++) {
				count[i] = dp[n][i];
			}

		}

		// 狙った和 m を作る方法の数を返す
		// ※mが0の場合、カードを一切選ばないという1通りも含んでいる
		long getCount(int m) {
			return count[m - l];
		}

		// 狙った和 m を作れるかどうかを返す
		boolean canAble(int m) {
			return 0 < count[m - l];
		}

	}

}
