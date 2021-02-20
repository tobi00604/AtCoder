package abc138.D;

import java.util.*;

// Ki
// 解説を読んでからやってみた
public class Main {

	static List<List<Integer>> ki; // グラフ
	static boolean[] asi; // DFSの足跡記録用
	static long[] counter; // 答え保持用

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int q = Integer.parseInt(sc.next());
		ki = new ArrayList<List<Integer>>();
		asi = new boolean[n];
		counter = new long[n];
		for (int v = 0; v < n; v++) {
			ki.add(new ArrayList<Integer>());
			asi[v] = false;
			counter[v] = 0;
		}
		for (int e = 0; e < n - 1; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			ki.get(from).add(to);
			ki.get(to).add(from);
		}
		for (int i = 0; i < q; i++) {
			int p = Integer.parseInt(sc.next()) - 1; // 点番号
			long x = Integer.parseInt(sc.next()); // カウンター増加値
			counter[p] += x;
		}

		dfs(0, 0);

		System.out.println(Arrays.toString(counter).replace("[", "").replace(",", "").replace("]", ""));

	}

	static void dfs(int v, long plus) {

		// 新しい頂点に到着したので記録
		asi[v] = true;
		counter[v] += plus;

		// 次の頂点へ
		for (int next : ki.get(v)) {

			if (asi[next] == false) {
				dfs(next, counter[v]);
			}
		}
	}
}
