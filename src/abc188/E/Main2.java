package abc188.E;

import java.util.*;

// 入出力例すらACにならないが、自分なりの到達点として提出。

// kane[v] := 点vで金塊を売ったときの値段
// from[v] := 点vに到達可能な金塊のうち、最も安い金塊の出身地
// を作れば、kane[v]-kane[from[v]] の最大値が答えになるのでは？
// …と思って以下実装したが、金塊を買った町ですぐ売ることができてしまいWAになる。

public class Main2 {

	static List<List<Integer>> graph; // グラフ
	static boolean[] asi;
	static int[] kane;
	static int[] from;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		asi = new boolean[n];
		kane = new int[n];
		from = new int[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
			kane[v] = Integer.parseInt(sc.next());
			from[v] = -1;
		}
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int a = Integer.parseInt(sc.next()) - 1; // 始点
			int b = Integer.parseInt(sc.next()) - 1; // 終点
			graph.get(a).add(b);
		}

		// DFS
		for (int v = 0; v < n; v++) {
			if (!asi[v]) {
				dfs(v, v);
			}
		}

//		// kaneの確認用
//		for (int v = 0; v < n; v++) {
//			System.out.println("点" + (v + 1) + "[" + kane[v] + "]");
//			for (int e : graph.get(v)) {
//				System.out.println("　⇒点" + (e + 1) + "[" + kane[e] + "]");
//			}
//		}
//		System.out.println();
//
//		// lowの確認用
//		for (int v = 0; v < n; v++) {
//			System.out.println("点" + (v + 1) + "：" + (from[v] + 1));
//		}
//		System.out.println();

		// 答え
		int result = 0;
		for (int v = 0; v < n; v++) {
			result = Math.max(result, kane[v] - kane[from[v]]);
		}
		System.out.println(result);
	}

	static void dfs(int v, int f) {
		asi[v] = true;
		from[v] = (kane[f] < kane[v]) ? f : v;
		for (int e : graph.get(v)) {
			if (!asi[e]) {
				dfs(e, from[v]);
			}
		}
	}

}