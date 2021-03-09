package abc191.E;

import java.util.*;

// コンテスト中は完成できなかったので今さら再挑戦。
// 散歩の出発町を表す点をグラフに増設してからダイクストラして散歩距離を求める方針。
// ↑公式解説とは違うやりかただが、入出力例１～３はうまく通ったので提出してみる。
public class Main2 {

	static List<List<Edge>> graph;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数

		// 重み付き有向グラフ
		// ただし今回の問題は出発町と到着町を区別したいので点を2重にする
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

		// 各町からダイクストラ
		for (int s = 0; s < n; s++) {

			// 仮のスタート地点を増設
			graph.add(new ArrayList<Edge>());
			for (Edge e : graph.get(s)) {
				graph.get(n).add(new Edge(e.to, e.w));
			}

			// 仮のスタート地点からダイクストラ
			long[] saitan = dijkstra(n);
			System.out.println(saitan[s] == Long.MAX_VALUE ? -1 : saitan[s]);

			// 仮のスタート地点を削除
			graph.remove(n);
		}

	}

	// startから各点への最短距離（優先度キューを使うver）
	static long[] dijkstra(int start) {

		// 変数初期化して、スタート駅をキューに入れる
		long[] result = new long[graph.size()];
		Arrays.fill(result, Long.MAX_VALUE);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Long.compare(result[a], result[b]));
		pq.add(start);
		result[start] = 0;

		while (!pq.isEmpty()) {

			// 出発点v（resultが最も小さい町）から伸びている道それぞれ
			int v = pq.poll();
			for (Edge e : graph.get(v)) {

				// 次の町を緩和できたら、そこから先も調べたいのでキューに追加
				if (result[e.to] > result[v] + e.w) {
					result[e.to] = result[v] + e.w;
					pq.add(e.to);
				}
			}

		}

		return result;
	}

	// startから各点への最短距離（単純ver）
	// ※TLEになったのでコメントアウト
//	static long[] dijkstra(int start) {
//
//		// 変数初期化
//		long[] result = new long[graph.size()];
//		boolean[] asi = new boolean[graph.size()];
//		Arrays.fill(result, Long.MAX_VALUE);
//		Arrays.fill(asi, false);
//		result[start] = 0;
//
//		for (int loop = 0; loop < graph.size(); loop++) {
//
//			// 出発点を決める
//			int now = -1;
//			long min = Long.MAX_VALUE;
//			for (int v = 0; v < graph.size(); v++) {
//				if (!asi[v] && result[v] < min) {
//					now = v;
//					min = result[v];
//				}
//			}
//
//			// 出発点が決まらなかったら終了してよい
//			if (now == -1) {
//				break;
//			}
//
//			// 出発点から伸びている道の先の点を緩和
//			for (Edge e : graph.get(now)) {
//				result[e.to] = Math.min(result[now] + e.w, result[e.to]);
//			}
//
//			// 今回の出発点は今後出発点に使うことはない
//			asi[now] = true;
//		}
//
//		return result;
//	}

	// 道１つの情報
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
