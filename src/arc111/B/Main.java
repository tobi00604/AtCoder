package arc111.B;

import java.util.*;

// 解説読んだら、全域木と見なして解く方針はバッチリ合っていた！
// これを提出してWAだった場合、原因がわからん。後日テストケースを見よう。
public class Main {

	// UnionFindを作るときに不要な枝を捨てたことのある木の
	// 根の番号を保持するリスト。グラフが木かどうかの判定に使う。
	public static Set<Integer> waste;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		waste = new HashSet<Integer>();
		int n = Integer.parseInt(sc.next());
		UnionFindTree uf = new UnionFindTree(400001);
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			uf.unite(a, b);
		}

		int result = 0;
		for (int i = 0; i < 400001; i++) {

			// この点が根ではないならスキップ
			if (uf.parent[i] != -1) {
				continue;
			}

			// 確認用
			// System.out.println("点" + i + "が根の木のサイズは" + uf.getSize(i));

			// この木のサイズ-1 がこの木のスコア。木の枝の本数は「サイズ-1」だから。
			result += uf.getSize(i) - 1;

			// この木を作るときに捨てた枝があったなら、スコアがさらに1増える
			if (waste.contains(i)) {
				result++;
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
				waste.add(root(x));
				return;
			}
			int rx = root(x); // xの根
			int ry = root(y); // yの根
			if (rx == ry) {
				waste.add(rx);
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
