package abc137.E;

import java.util.*;

// 前回の提出では、入出力例３にあるような「無意味な負閉路」に引っかかったので、
// 問題を解く際の "不要な点" を洗い出す処理を、ベルマンフォード法をする直前に追加。
// 参考にしたサイト　https://sigma1113.hatenablog.com/entry/2019/08/12/130042
public class Main2 {

	static public List<List<Edge>> graph;
	static public List<List<Edge>> graph2;
	static int[] result; // 点0から到達可能かどうかの判定結果

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		int p = Integer.parseInt(sc.next()); // 1回の移動にかかる料金
		int[] inputA = new int[m];
		int[] inputB = new int[m];
		long[] inputC = new long[m];
		for (int e = 0; e < m; e++) {
			inputA[e] = Integer.parseInt(sc.next()) - 1; // 始点
			inputB[e] = Integer.parseInt(sc.next()) - 1; // 終点
			inputC[e] = Long.parseLong(sc.next()); // 重み（今回はコインの枚数）
		}

		// DFSするための有向グラフを２種類作る
		// graph→問題どおりの有向グラフ
		// graph2→問題とは辺の向きを逆にした有向グラフ
		graph = new ArrayList<List<Edge>>();
		graph2 = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
			graph2.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = inputA[e]; // 始点
			int to = inputB[e]; // 終点
			graph.get(from).add(new Edge(to, 0));
			graph2.get(to).add(new Edge(from, 0));
		}

		// graphでDFSして、始点からたどりつけない点を洗い出し、
		// graph2でDFSして、終点へたどりつけない点を洗い出す
		result = new int[n];
		dfs(0);
		dfs2(n - 1);

		// 上記２回のDFSで洗い出した "不要な点" は無視して、
		// 改めてグラフを作る（問題を解くための重み付き有向グラフ）
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = inputA[e]; // 始点
			int to = inputB[e]; // 終点
			long w = inputC[e]; // 重み（今回はコインの枚数）

			// "不要な点" 判定
			if (result[from] != 11 || result[to] != 11) {
				continue;
			}

			// 今回の問題は1回移動するごとに料金 p がかかる
			w -= p;

			// 今回の問題は最長路問題なので重みを正負反転
			w *= -1;

			graph.get(from).add(new Edge(to, w));
			graph2.get(to).add(new Edge(from, w));
		}

		// 確認用
//		for (int v = 0; v < n; v++) {
//			System.out.println("点" + (v + 1));
//			for (Edge e : graph.get(v)) {
//				System.out.println("　⇒" + e.w + "⇒点" + (e.to + 1));
//			}
//		}

		// 以下、ベルマンフォード法。始点から各点への最短距離を求める。
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = Long.MAX_VALUE;
		}
		resultDist[0] = 0;

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

		// 結果出力
		if (resultNegativeCycle) {
			// 負閉路があった場合は No を出力
			System.out.println("-1");
		} else {
			// 負閉路がなかった場合は最短距離を正負反転して出力
			System.out.println(Math.max(0, -resultDist[n - 1]));
		}

	}

	// 始点からたどりつけない点を洗い出すためのDFS
	static void dfs(int v) {
		result[v]++;
		for (Edge e : graph.get(v)) {
			int next = e.to; // 次の点
			if (result[next] == 0) {
				dfs(next);
			}
		}
	}

	// 終点へたどりつけない点を洗い出すためのDFS
	static void dfs2(int v) {
		result[v] += 10;
		for (Edge e : graph2.get(v)) {
			int next = e.to; // 次の点
			if (result[next] < 10) {
				dfs2(next);
			}
		}
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