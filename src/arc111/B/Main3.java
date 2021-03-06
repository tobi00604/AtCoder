package arc111.B;

import java.util.*;

// 解説ページにもあるとおり、グラフが木かそうでないか、を判定する問題。
// 2021/01/09　全域木を作るときに不要な枝があるか、で判定しようとしてなぜかバグって失敗。いつか再挑戦したい。
// 2021/01/20　DFSを走らせて閉路を見つけたか、で判定して無事AC。
// 2021/01/26　木の性質 "辺の数＋１＝点の数" が成り立つか、で判定する方針を以下にて試してみる。
public class Main3 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int maxColor = 400001;
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// Union-Findを作る
		UnionFindTree uf = new UnionFindTree(maxColor);
		for (int i = 0; i < n; i++) {
			uf.unite(a[i], b[i]);
		}

		// n枚のカードを再び見て、辺の数を調べる
		int[] hen = new int[maxColor];
		for (int i = 0; i < n; i++) {
			hen[uf.root(a[i])]++;
		}

		// 確認用（maxColor個の値が並ぶので注意）
//		System.out.println(Arrays.toString(hen));
//		uf.printAllNode();

		// 答えを出す
		int result = 0;
		boolean[] used = new boolean[maxColor];
		for (int v = 0; v < maxColor; v++) {

			// もう見終わった連結成分ならばスキップ
			if (used[uf.root(v)] == true) {
				continue;
			}

			// 問題に登場しない色はスキップ
			if (hen[v] == 0) {
				continue;
			}

			used[uf.root(v)] = true;

			// 点vを含む連結成分は "辺の数＋１＝点の数" が成り立つか？
			if (hen[v] + 1 == uf.getSize(v)) {
				result += hen[v]; // 辺の数がスコア
			} else {
				result += uf.getSize(v); // 点の数がスコア
			}
		}

		System.out.println(result);
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
