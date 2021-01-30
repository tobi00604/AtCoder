package abc168.D;

import java.util.*;

// 解説を読んでからやってみた。
// 点0から各点へ最短歩数で移動したいので、BFS木を作る。
public class Main {

	static List<List<Integer>> graph; // グラフ
	static int[] dist; // 点0からの最短歩数
	static int[] pre; // ひとつ前の点

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			graph.get(from).add(to);
			graph.get(to).add(from); // 無向グラフであれば逆向きもある
		}

		// 結果用配列を初期化してから、点0を始点としてBFS
		dist = new int[n];
		pre = new int[n];
		for (int v = 0; v < n; v++) {
			dist[v] = -1;
			pre[v] = -1;
		}
		bfs(0);

		// Noの場合の結果出力
		for (int v = 0; v < n; v++) {
			if (dist[v] == -1) {
				System.out.println("No");
				return;
			}
		}

		// Yesの場合の結果出力
		System.out.println("Yes");
		for (int v = 0 + 1; v < n; v++) {
			System.out.println(pre[v] + 1);
		}

	}

	static void bfs(int s) {

		// スタート地点をキューに入れる
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(s);
		dist[s] = 0;

		// キューが空になるまでループ
		while (!queue.isEmpty()) {

			// キューからひとつ取り出す
			int v = queue.poll();

			// 次の点それぞれ処理
			for (int next : graph.get(v)) {

				// 過去に調べた点は行かない
				if (dist[next] != -1) {
					continue;
				}

				// キューに入れる
				pre[next] = v;
				dist[next] = dist[v] + 1;
				queue.add(next);
			}

		}
	}
}