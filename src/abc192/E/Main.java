package abc192.E;

import java.util.*;

// 解説を読んでからやってみた
// やってることはダイクストラ
public class Main {

	static int n; // 点の数
	static int m; // 辺の数
	static int startSta; // スタート駅
	static int goalSta; // ゴール駅
	static List<List<Edge>> graph; // グラフ
	static long[] time; // 各点に到着できる時刻

	public static void main(String[] args) {

		// 入力（今回は重みなしグラフとする）
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		startSta = Integer.parseInt(sc.next()) - 1;
		goalSta = Integer.parseInt(sc.next()) - 1;
		graph = new ArrayList<List<Edge>>();
		time = new long[n];
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
			time[v] = Long.MAX_VALUE;
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			long w = Long.parseLong(sc.next());
			long go = Long.parseLong(sc.next());
			graph.get(from).add(new Edge(to, w, go));
			graph.get(to).add(new Edge(from, w, go)); // 無向グラフであれば逆向きもある
		}

		// 探索！
		search();
		System.out.println(time[goalSta] == Long.MAX_VALUE ? -1 : time[goalSta]);

	}

	static void search() {

		// スタート駅をキューに入れる
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Long.compare(time[a], time[b]));
		pq.add(startSta);
		time[startSta] = 0;

		while (!pq.isEmpty()) {

			// この周で調べる駅を決める(最もtimeが小さい駅)
			int v = pq.poll();

			// 伸びている枝の先の駅それぞれ
			for (Edge e : graph.get(v)) {

				// 最速到着時刻を更新できたら、そこから先を調べたいのでキューに追加しておく
				if (time[e.to] > calc(time[v], e.go, e.w)) {
					time[e.to] = calc(time[v], e.go, e.w);
					pq.add(e.to);
				}
			}

		}
	}

	// 枝で移動した先の駅に到着する時刻を求める
	static long calc(long now, long go, long w) {
		if (now % go == 0) {
			return now + w;
		} else {
			return now + (go - (now % go)) + w;
		}
	}

	// 枝情報
	static class Edge {

		int to; // 行先の頂点
		long w; // この辺を移動するのにかかる時間
		long go; // この辺を走る電車の出発時刻

		// コンストラクタ
		public Edge(int to, long w, long go) {
			this.to = to;
			this.w = w;
			this.go = go;
		}
	}
}