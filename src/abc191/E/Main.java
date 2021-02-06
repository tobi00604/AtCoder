package abc191.E;

import java.util.*;

// 重みつき有向グラフの最短経路問題、ただし「始点と終点が同じ点」。
// 30分ほど費やして、DFSのプログラムを作ったけど
// なんかよくわかんない。作りかけ。未提出。
public class Main {

	static int s;
	static long[] result;
	static boolean[] asi;
	static List<List<Edge>> graph;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数

		// 重み付き有向グラフ
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			long w = Long.parseLong(sc.next()); // 重み
			graph.get(from).add(new Edge(to, w));
		}

		// 確認用
		for (int v = 0; v < n; v++) {
			System.out.println("点" + v);
			for (Edge e : graph.get(v)) {
				System.out.println("　⇒" + e.w + "⇒点" + e.to);
			}
		}

		// 各始点について
		for (s = 0; s < n; s++) {

			// 変数初期化
			result = new long[n];
			asi = new boolean[n];
			for (int i = 0; i < n; i++) {
				result[i] = Long.MAX_VALUE;
				asi[i] = false;
			}
			result[s] = 0;
			asi[s] = true;

			// 探索
			dfs(s, 0);

			// 結果出力
			if (result[s] == 0) {
				// 帰ってこれないなら-1
				System.out.println("-1");
			} else {
				// 始点から始点への最短距離
				System.out.println(result[s]);
			}
		}

	}

	static void dfs(int v, long dist) {
		System.out.println(v + "_" + dist);
		asi[v] = true;
		result[v] = dist;
		for (Edge e : graph.get(v)) {
			int next = e.to; // 次の点
			long newDist = e.w; // 次の点への重み
			if (next == s) {
				if (result[s] == 0) {
					result[s] = dist;
				} else {
					result[s] = Math.min(result[s], dist);
				}
			} else {
				dfs(next, dist + newDist);
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
