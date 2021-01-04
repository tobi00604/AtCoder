package abc177.D;

import java.util.*;

// バケットではなくUnionFindでやってみた
public class Main5 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		UnionFindTree uf = new UnionFindTree(n);
		for (int i = 0; i < m; i++) {
			int left = Integer.parseInt(sc.next());
			int right = Integer.parseInt(sc.next());
			uf.unite(left - 1, right - 1);
		}

		// コーナーケース
		if (m == 0) {
			System.out.println(1);
			return;
		}

		// 確認用
		uf.printAllNode();

		// 最も友達が多い人の、グループの人数を求めれば、それが答え
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < uf.getSize(i)) {
				max = uf.getSize(i);
			}
		}

		System.out.println(max);

	}
}

class UnionFindTree {

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