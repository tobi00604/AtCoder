package abc157.D;

import java.util.*;

// 解説を読んでからやってみたが、TLEになった。後半の2重ループがたぶんダメ。
// UnionFindで「点iを含むグループの点列挙」ができれば早そう。
// つまりUnionFindの木に対してDFSする必要があるってこと？
// 連結リストの持ち方だとDFSキツそう、可変長配列の配列に持ち直す必要ありそう。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int friendNum = Integer.parseInt(sc.next());
		int blockNum = Integer.parseInt(sc.next());
		List<Pair> friendList = new ArrayList<Pair>();
		for (int i = 0; i < friendNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			friendList.add(new Pair(a, b));
			friendList.add(new Pair(b, a));
		}
		List<Pair> blockList = new ArrayList<Pair>();
		for (int i = 0; i < blockNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			blockList.add(new Pair(a, b));
			blockList.add(new Pair(b, a));
		}

		// 友達関係でつながっているグループ
		UnionFindTree uf = new UnionFindTree(n);
		for (Pair p : friendList) {
			uf.unite(p.a, p.b);
		}

		// 確認用
		uf.printAllNode();

		// n行のクエリ
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {

			// 自分のいる友達グループの人数
			int temp = uf.getSize(i);
			// System.out.println(i + "：" + temp);

			// すでに友達の人数をひく
			for (Pair p : friendList) {
				if (i == p.a && uf.isSame(i, p.b)) {
					// System.out.println(" F" + i + p.b);
					temp--;
				}
			}

			// ブロックの人数をひく
			for (Pair p : blockList) {
				if (i == p.a && uf.isSame(i, p.b)) {
					// System.out.println(" B" + i + p.b);
					temp--;
				}
			}

			// 自分をひく
			temp--;

			// 残った結果が友達候補
			result[i] = temp;
		}

		// 結果出力
		String resultStr = "" + result[0];
		for (int i = 0 + 1; i < n; i++) {
			resultStr += " " + result[i];
		}
		System.out.println(resultStr);
	}
}

class Pair {

	int a;
	int b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
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