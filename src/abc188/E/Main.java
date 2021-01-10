package abc188.E;

import java.util.*;

// コーディング中で時間切れ。
// DFSで儲けの最大値を探すのだと思うが、
// DFSの計算量がO(V+E)、旅のスタート地点がO(n)、合計O(n(V+E))
// となって間に合わない気がする。
// そこで、旅の途中で訪れた点で金を買った場合も同時進行で調査することで
// 「さっき通った点からまた旅をリスタート」しなくて済むようにするとか？
public class Main {

	static List<List<Edge>> graph; // グラフ
	static long mouke = -1;
	static boolean[] asi;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数

		long[] kane = new long[n]; // 金の価値
		for (int v = 0; v < n; v++) {
			kane[v] = Long.parseLong(sc.next());
		}

		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			long w = 0; // 重み
			graph.get(from).add(new Edge(to, w));
		}

		// 確認用
		for (int v = 0; v < n; v++) {
			System.out.println("点" + v);
			for (Edge e : graph.get(v)) {
				System.out.println("　⇒" + e.w + "⇒点" + e.to);
			}
		}

		// 以下作りかけ
		asi = new boolean[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
		}
		dfs(0);
		System.out.println(Arrays.toString(asi));

	}

	static void dfs(int v) {
		asi[v] = true;
		for (Edge e : graph.get(v)) {
			int next = e.to; // 次の点
			if (asi[next] == false) {
				dfs(next);
			}
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