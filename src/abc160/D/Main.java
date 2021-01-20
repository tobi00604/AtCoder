package abc160.D;

import java.util.*;

// 解説を読んでからやってみた
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// 最短経路がkとなるような道はいくつあるか？という問題だが、
		// 制約をよく見ると問題サイズが小さいので
		// 始点と終点のペアすべての最短経路を求めても間に合う。

		int[] result = new int[n];
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {

				// 橋を使わなかったときの距離
				int l1 = j - i;

				// 橋をXからYへ向かって通ったときの距離
				int l2 = 1;
				l2 += Math.abs(x - i);
				l2 += Math.abs(y - j);

				// 橋をYからXへ向かって通ったときの距離
				int l3 = 1;
				l3 += Math.abs(y - i);
				l3 += Math.abs(x - j);

				// 最短距離だけを記録
				result[Math.min(Math.min(l1, l2), l3)]++;

			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(result[i]);
		}

	}
}
