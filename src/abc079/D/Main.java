package abc079.D;

import java.util.*;

// 重みつき有向グラフを作って点1から各点へ行く最短コストを求めれば答えを出せるのでは？
// と思ったのでやってみる。でもダイクストラ法やったことないからベルマンフォード法で。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int n = 10; // 点の数
		int m = 90; // 辺の数
		int s = 1; // 始点
		List<List<Edge>> graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				long cost = Integer.parseInt(sc.next());
				if (i != j) {
					graph.get(j).add(new Edge(i, cost));
				}
			}
		}
		int[] target = new int[h * w];
		for (int i = 0; i < h * w; i++) {
			target[i] = Integer.parseInt(sc.next());
		}

		// 確認用
		// for (int v = 0; v < n; v++) {
		// System.out.println("点" + v);
		// for (Edge e : graph.get(v)) {
		// System.out.println("　⇒" + e.w + "⇒点" + e.to);
		// }
		// }

		// ここからベルマンフォード法
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = Long.MAX_VALUE;
		}
		resultDist[s] = 0;

		// 緩和処理をn回反復することで答えを求めていく
		for (int iter = 0; iter < n; iter++) {

			boolean updateFlg = false;

			// 点それぞれについて
			for (int v = 0; v < n; v++) {

				// 自身がまだ ∞ なら、そこから出ていく辺は考慮外
				if (resultDist[v] == Long.MAX_VALUE) {
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

		// ここまでベルマンフォード法
		// resultDist[]に、点1から各点への最短コストが入った

		// 答えを求めて出力
		long totalCost = 0;
		for (int i = 0; i < h * w; i++) {
			if (target[i] == -1) {
				continue;
			}
			totalCost += resultDist[target[i]];
		}
		System.out.println(totalCost);
	}

	static class Edge {

		int to; // 行先の頂点
		long w; // この辺の重み

		// コンストラクタ
		public Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}
	}
}
