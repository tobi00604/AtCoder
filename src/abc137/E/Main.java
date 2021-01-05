package abc137.E;

import java.util.*;

// 正解にならないコードだが、自分なりの到達点として提出しておく。
// このコードだと、入出力例３にあるような「無意味な負閉路」を拾って -1 を出力してしまう。
// 「無意味な負閉路」は無視しなければならない！
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		int p = Integer.parseInt(sc.next()); // 1回の移動にかかる料金

		// 重み付き有向グラフ
		List<List<Edge>> graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			long w = Long.parseLong(sc.next()); // 重み（今回はコインの枚数）

			// 今回の問題は1回移動するごとに料金 p がかかる
			w -= p;

			// 今回の問題は最長路問題なので重みを正負反転
			w *= -1;

			graph.get(from).add(new Edge(to, w));
		}

		// // 確認用
		// for (int v = 0; v < n; v++) {
		// System.out.println("点" + v);
		// for (Edge e : graph.get(v)) {
		// System.out.println("　⇒" + e.w + "⇒点" + e.to);
		// }
		// }

		// 以下、ベルマンフォード法。始点から各点への最短距離を求める。
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = 9999999;
		}
		resultDist[0] = 0;

		// 緩和処理をn回反復することで答えを求めていく
		for (int iter = 0; iter < n; iter++) {

			boolean updateFlg = false;

			// 点それぞれについて
			for (int v = 0; v < n; v++) {

				// 自身がまだ ∞ なら、そこから出ていく辺は考慮外
				if (resultDist[v] == 9999999) {
					continue;
				}

				// この点から出ていく辺それぞれについて
				for (Edge e : graph.get(v)) {

					// 緩和
					if (resultDist[v] + e.w < resultDist[e.to]) {
						resultDist[e.to] = resultDist[v] + e.w;
						updateFlg = true;
					}
				}
			}

			// 一度も緩和が発生しなかったら問題は解けている
			if (!updateFlg) {
				break;
			}

			// n回目の反復でも緩和が発生したら負閉路があったということ
			if (iter == n - 1 && updateFlg) {
				resultNegativeCycle = true;
			}
		}

		// 結果出力
		if (resultNegativeCycle) {
			// 負閉路があった場合は No を出力
			System.out.println("-1");
		} else {
			// 負閉路がなかった場合は最短距離を正負反転して出力
			System.out.println(-resultDist[n - 1]);
		}

	}
}

class Edge {

	int to; // 行先の頂点
	long w; // この辺の重み

	// コンストラクタ
	public Edge(int to, long w) {
		this.to = to;
		this.w = w;
	}
}