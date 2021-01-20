package arc111.B;

import java.util.*;

// 前回の提出ではunionfindで問題を解こうとしてなぜかバグったので
// 通常の無向グラフで解いてみる。
public class Main3 {

	static List<List<Integer>> graph; // グラフ
	static int[] asi; // DFSの足跡記録用
	static Set<Integer> nonTree; // 木ではないと分かったグラフの始点番号
	static Map<Integer, Integer> map; // 連結成分のサイズ

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = 400001; // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v <= n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()); // 始点
			int to = Integer.parseInt(sc.next()); // 終点
			graph.get(from).add(to);
			graph.get(to).add(from); // 無向グラフなので逆向きもある
		}

		// 変数初期化
		asi = new int[n + 1];
		nonTree = new HashSet<Integer>();
		map = new TreeMap<Integer, Integer>();

		// DFSを繰り返す
		for (int v = 0; v < n; v++) {

			// もう調べた点はスキップ
			if (asi[v] == 1) {
				continue;
			}

			// 枝が一切ない点（つまり問題に登場しない色）はスキップ
			if (graph.get(v).size() == 0) {
				continue;
			}

			// この点からDFS開始
			map.put(v, 0);
			dfs(v, -1, v);
		}

		// 答えを出す
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (asi[entry.getKey()] == 1) {
				result += entry.getValue();
				if (!nonTree.contains(entry.getKey())) {
					result--;
				}
			}
		}
		System.out.println(result);

	}

	static void dfs(int v, int from, int root) {

		// 新しい頂点に到着したので記録
		asi[v]++;
		map.replace(root, map.get(root) + 1);

		// 次の頂点へ
		for (int next : graph.get(v)) {

			// ひとつ前の点に戻るような動きは禁止
			// ※無向グラフなので点と点の間に往路と復路の２本の枝があり
			// 復路を使うと木なのに閉路だと判断してしまうため
			if (next == from) {
				continue;
			}

			if (asi[next] == 0) {
				dfs(next, v, root);
			} else {
				// 一度踏んだ点へ行こうとしていたらこれは木ではない
				nonTree.add(root);
			}
		}
	}
}
