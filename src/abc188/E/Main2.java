package abc188.E;

import java.util.*;

// コーディング中で時間切れ。
// DFSで儲けの最大値を探すのだと思うが、
// DFSの計算量がO(V+E)、旅のスタート地点がO(n)、合計O(n(V+E))
// となって間に合わない気がする。
// そこで、旅の途中で訪れた点で金を買った場合も同時進行で調査することで
// 「さっき通った点からまた旅をリスタート」しなくて済むようにするとか？
public class Main2 {

	static List<List<Integer>> graph; // グラフ
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

		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			graph.get(from).add(to);
		}

		// 確認用
		for (int v = 0; v < n; v++) {
			System.out.println("点" + (v + 1));
			for (int e : graph.get(v)) {
				System.out.println("　⇒点" + (e + 1));
			}
		}

	}

	static void dfs(int v) {
		asi[v] = true;
		for (int e : graph.get(v)) {
			if (asi[e] == false) {
				dfs(e);
			}
		}
	}
}