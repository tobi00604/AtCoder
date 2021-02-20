package abc188.E;

import java.util.*;

// さっきの提出をちょっと改造。
// mouke[v] := 点vで金塊を売ったときに得られる儲けの最大値
// を作ることにした。解説PDFの解法１と発想は同じだが計算式が違う。ACなるか？
public class Main3 {

	static List<List<Integer>> graph; // グラフ
	static boolean[] asi;
	static int[] kane;
	static int[] mouke;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		asi = new boolean[n];
		kane = new int[n];
		mouke = new int[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
			kane[v] = Integer.parseInt(sc.next());
			mouke[v] = Integer.MIN_VALUE;
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
				dfs(v, Integer.MAX_VALUE);
			}
		}

		// kaneの確認用
		for (int v = 0; v < n; v++) {
			System.out.println("点" + (v + 1) + "[" + kane[v] + "]");
			for (int e : graph.get(v)) {
				System.out.println("　⇒点" + (e + 1) + "[" + kane[e] + "]");
			}
		}
		System.out.println();

		// lowの確認用
		for (int v = 0; v < n; v++) {
			System.out.println("点" + (v + 1) + "：" + mouke[v]);
		}
		System.out.println();

		// 答え
		int result = Integer.MIN_VALUE;
		for (int v = 0; v < n; v++) {
			result = Math.max(result, mouke[v]);
		}
		System.out.println(result);
	}

	static void dfs(int v, int f) {
		asi[v] = true;
		mouke[v] = kane[v] - f;
		for (int e : graph.get(v)) {
			if (!asi[e]) {
				dfs(e, Math.min(kane[v], f));
			}
		}
	}

}