package abc126.D;

import java.util.*;

// DFSを走らせて、長さ奇数の枝を通るたびに色を反転しながら点に着色していく、
// という方針を思いついたのでやってみる
public class Main {

	static List<List<Edge>> graph; // グラフ
	static boolean[] result; // 点0から到達可能かどうかの判定結果
	static boolean[] white;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = n - 1; // 辺の数
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			long w = Long.parseLong(sc.next()); // 重み
			graph.get(from).add(new Edge(to, w));
			graph.get(to).add(new Edge(from, w));
		}

		// 確認用
		// for (int v = 0; v < n; v++) {
		// System.out.println("点" + v);
		// for (Edge e : graph.get(v)) {
		// System.out.println("　⇒" + e.w + "⇒点" + e.to);
		// }
		// }

		// 探索
		result = new boolean[n];
		white = new boolean[n];
		Arrays.fill(result, false);
		Arrays.fill(white, false);
		dfs(0, true);

		// 結果
		for (int v = 0; v < n; v++) {
			System.out.println(white[v] ? 1 : 0);
		}

	}

	static void dfs(int v, boolean color) {
		result[v] = true;
		white[v] = color;
		for (Edge e : graph.get(v)) {
			if (result[e.to] == false) {
				dfs(e.to, (e.w % 2 == 0) ? white[v] : !white[v]);
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
