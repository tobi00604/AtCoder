package abc157.D;

import java.util.*;

//UnionFindではなく通常のグラフの問題としてやってみよう
public class Main2 {

	public static List<List<Integer>> graph;
	public static List<List<Integer>> graph2;
	static int now; // 自分の番号
	static List<Integer> friends; // 自分のいるグループの友達
	static int dislike; // 自分のいるグループで、自分のブロック人数

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int friendNum = Integer.parseInt(sc.next());
		int blockNum = Integer.parseInt(sc.next());

		// 入力（友達関係の無向グラフ）
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < friendNum; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			graph.get(from).add(to);
			graph.get(to).add(from); // 無向グラフなので逆向きもある
		}

		// 入力（ブロック関係の無向グラフ）
		graph2 = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph2.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < blockNum; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			graph2.get(from).add(to);
			graph2.get(to).add(from); // 無向グラフなので逆向きもある
		}

		// n行のクエリ
		int[] result = new int[n];
		for (now = 0; now < n; now++) {

			// 探索(DFS)
			friends = new ArrayList<Integer>();
			dislike = 0;
			dfs(now);
			result[now] = friends.size();

			// すでに友達の人数をひく
			result[now] -= graph.get(now).size();

			// ブロックの人数をひく
			result[now] -= dislike;

			// 自分をひく
			result[now]--;
		}

		// 結果出力
		StringBuilder resultStr = new StringBuilder();
		resultStr.append(result[0]);
		for (int i = 0 + 1; i < n; i++) {
			resultStr.append(" " + result[i]);
		}
		System.out.println(resultStr);
	}

	static void dfs(int v) {
		friends.add(v);

		if (graph2.get(now).contains(v)) {
			dislike++;
		}

		for (int e : graph.get(v)) {
			if (!friends.contains(e)) {
				dfs(e);
			}
		}
	}
}