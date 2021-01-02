package abc187.D;

import java.util.*;

// 未完成（問題ページにある入出力例１すらACにならない）だがせっかくなので提出。
// ・ソートがおかしい（z[]に重複値があるのにTreeMapが使えるわけがない）
// ・解説を読むとそもそも解き方が違う（二分探索なんてやってない）
public class Main {

	static int n;
	static int[] x;
	static int[] y;
	static long[] rui1;
	static long[] rui2;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		x = new int[n];
		y = new int[n];
		int[] z = new int[n]; // ソート用
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
			y[i] = Integer.parseInt(sc.next());
			z[i] = x[i] + y[i];
		}

		// TreeMapを経由することで、zのソートに連動させてxとyもソート
		Map<Integer, Integer> mapX = new TreeMap<>();
		Map<Integer, Integer> mapY = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			mapX.put(z[i], x[i]);
			mapY.put(z[i], y[i]);
		}
		int index = n - 1;
		for (int v : mapX.values()) {
			x[index] = v;
			index--;
		}
		index = n - 1;
		for (int v : mapY.values()) {
			y[index] = v;
			index--;
		}

		// 累積和を作っておく
		rui1 = new long[n];
		rui1[0] = x[0] + y[0];
		for (int i = 0 + 1; i < n; i++) {
			rui1[i] = rui1[i - 1] + x[i] + y[i];
		}
		rui2 = new long[n];
		rui2[n - 1] = x[n - 1];
		for (int i = n - 1 - 1; i >= 0; i--) {
			rui2[i] = rui2[i + 1] + x[i];
		}

		// 確認用
//		for (int i = 0; i < n; i++) {
//			System.out.println(x[i] + " $ " + y[i]);
//		}
//		System.out.println(Arrays.toString(rui1));
//		System.out.println(Arrays.toString(rui2));

		// 二分探索の初期値
		int left = 0; // f(0)はfalse
		int right = n; // f(市の数)はtrue

		// 二分探索の基本形　ここから
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (f(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// 二分探索の基本形　ここまで

		// 上記のwhileループを抜けた時点で、leftとrightが隣合せ、かつ、
		// f(left)がfalseでf(right)がtrueになっている

		// 今回はrightをそのまま出力
		System.out.println(right);

	}

	// x回の演説で勝てるか？
	static boolean f(int en) {

		// 演説をまったくしないと負け
		if (en == 0) {
			return false;
		}

		// 全ての市で演説すると勝ち
		if (en == n) {
			return true;
		}

		long taka = rui1[en - 1];
		long aoki = rui2[en];

		return aoki < taka;
	}
}
