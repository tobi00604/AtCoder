package abc157.D;

import java.util.*;

// unionfindでやってみたらTLE
// 普通のグラフの問題と捉えてやってみたらTLE
// そこで両方を併用して解いてみる、さらにブロックリストの集計を最後にまとめてやってみる
public class Main3 {

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

		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		List<Pair> friendList = new ArrayList<Pair>();
		for (int i = 0; i < friendNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			friendList.add(new Pair(a, b));
			friendList.add(new Pair(b, a));
			graph.get(a).add(b);
			graph.get(b).add(a); // 無向グラフなので逆向きもある
		}

		graph2 = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph2.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < blockNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			graph2.get(a).add(b);
			graph2.get(b).add(a); // 無向グラフなので逆向きもある
		}

		// 友達関係でつながっているグループ
		UnionFindTree uf = new UnionFindTree(n);
		for (Pair p : friendList) {
			uf.unite(p.a, p.b);
		}

		// 確認用
		// uf.printAllNode();

		// n行のクエリ
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {

			// 自分のいる友達グループの人数
			result[i] = uf.getSize(i);

			// すでに友達の人数を引く
			result[i] -= graph.get(i).size();

			// 自分を引く
			result[i]--;
		}

		// ブロックしている人は答えから引く
		for (int i = 0; i < n; i++) {
			for (int j : graph2.get(i)) {
				if (uf.isSame(i, j)) {
					result[i]--;
				}
			}
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

	static class Pair {

		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static class UnionFindTree {

		int[] parent;
		int[] size;

		// コンストラクタ
		UnionFindTree(int n) {
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = -1;
				size[i] = 1;
			}
		}

		// xが属する木の根を返す
		int root(int x) {
			if (parent[x] == -1) {
				return x;
			}
			parent[x] = root(parent[x]); // ついでに経路圧縮
			return parent[x];
		}

		// xとyが同じ木にいるかどうか調べて返す
		boolean isSame(int x, int y) {
			return root(x) == root(y);
		}

		// xとyを同じ木にする
		void unite(int x, int y) {
			if (x == y) {
				return;
			}
			int rx = root(x); // xの根
			int ry = root(y); // yの根
			if (rx == ry) {
				return;
			}
			// 木の高さをおさえる工夫をしておく
			if (size[rx] < size[ry]) {
				int tmp = rx;
				rx = ry;
				ry = tmp;
			}
			// つなぐ
			parent[ry] = rx;
			size[rx] += size[ry];
		}

		// xが属する木のサイズを返す
		int getSize(int x) {
			return size[root(x)];
		}

		// 確認用
		void printAllNode() {

			System.out.println(Arrays.toString(parent));
			System.out.println(Arrays.toString(size));

			for (int i = 0; i < parent.length; i++) {
				System.out.println(i + "の根は" + root(i));
				System.out.println(i + "の高さは" + getSize(i));
			}
		}
	}
}