package s8pc_4.B;

import java.util.*;

// https://atcoder.jp/contests/s8pc-4/tasks/s8pc_4_b
// この提出もWAだったら原因が分からん
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		long[] input = new long[n];
		for (int i = 0; i < n; i++) {
			input[i] = Long.parseLong(sc.next());
		}

		// n個の建物のうち、どれを増築するか？
		// 問題サイズが小さいので 2のn乗 すべて試す。

		// 「2のn乗」回ループ
		long minCost = Long.MAX_VALUE;
		for (int i = 0; i < (1 << n); i++) {

			// 変数初期化
			long cost = 0;
			long highest = 0;
			long[] a = new long[n];
			for (int j = 0; j < n; j++) {
				a[j] = input[j];
			}

			// 増築する建物だけ増築していく
			highest = a[0];
			for (int j = 1; j < n; j++) {
				if ((1 & i >> j) == 1 && a[j] <= highest) {
					cost += highest - a[j] + 1;
					a[j] += highest - a[j] + 1;
					highest = a[j];
				}
			}

			// カラフル条件クリアしているか確認
			int colorful = 0;
			highest = 0;
			for (int j = 0; j < n; j++) {
				// System.out.print(a[j]);
				if (highest < a[j]) {
					highest = a[j];
					colorful++;
				}
			}
			// System.out.println(" " + (k <= colorful) + " " + cost);

			if (k <= colorful) {
				minCost = Math.min(minCost, cost);
			}

		}

		System.out.println(minCost);
	}
}
