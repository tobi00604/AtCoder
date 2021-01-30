package abc190.E;

import java.util.*;

public class Main {

	static List<List<Integer>> graph; // グラフ
	static boolean[] asi; // dfsの足跡

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}
		int k = Integer.parseInt(sc.next());
		int[] c = new int[k];
		for (int i = 0; i < k; i++) {
			c[i] = Integer.parseInt(sc.next());
		}

		// とりあえず答えが-1かどうかを判定
		UnionFindTree uf = new UnionFindTree(n + 1);
		for (int i = 0; i < m; i++) {
			uf.unite(a[i], b[i]);
		}
		for (int i = 0 + 1; i < k; i++) {
			if (!uf.isSame(c[i - 1], c[i])) {
				System.out.println(-1);
				return;
			}
		}
		
		// 無向グラフを作る
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()); // 始点
			int to = Integer.parseInt(sc.next()); // 終点
			graph.get(from).add(to);
			graph.get(to).add(from); // 無向グラフで逆向きもある
		}
		
		// BFSで石列の長さを求める。
		// ※すべてのスタート地点（k通り）やる必要がある
		// ※すべての目的地をひととおり踏んだらBFSを中断していい
		// ※行きがけと帰りがけの両方にコストがかかることに注意
		for(int start = 1; start <= k; start++){
			// ここで時間切れ
		}

	}

	static void dfs(int v) {
		asi[v] = true;
		for (int e : graph.get(v)) {
			int next = e; // 次の点
			if (asi[next] == false) {
				dfs(next);
			}
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
