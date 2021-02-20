package abc188.E;

import java.util.*;

// 今までいろいろ提出してきたがギブアップ。解説PDFの通りにDPしてみる。
public class Main4 {

	static List<List<Integer>> graph; // グラフ
	static int[] kane;
	static int[] dp;
	static boolean[] available;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		kane = new int[n];
		dp = new int[n];
		available = new boolean[n];
		for (int v = 0; v < n; v++) {
			kane[v] = Integer.parseInt(sc.next());
			dp[v] = Integer.MAX_VALUE;
			available[v] = false;
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

		// dp[v] := 点vに到達可能な金塊のうち最も安い価格
		dp[0] = kane[0];
		for (int v = 0; v < n; v++) {
			for (int e : graph.get(v)) {
				available[e] = true;
				dp[e] = Math.min(dp[v], Math.min(kane[v], dp[e]));
			}
		}

		// 答え
		int result = Integer.MIN_VALUE;
		for (int v = 0; v < n; v++) {
			if (available[v]) {
				result = Math.max(result, kane[v] - dp[v]);
			}
		}
		System.out.println(result);
	}

}