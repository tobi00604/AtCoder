package abc141.D;

import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] input;
	static int[] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		input = new int[n];
		result = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(sc.next());
		}

		// コーナーケース 0円で買えてしまう場合
		if (f(0)) {
			System.out.println(0);
			return;
		}

		// 二分探索の初期値
		long left = 0; // f(0)はfalse
		long right = Long.MAX_VALUE; // f(∞)はtrue

		// 二分探索の基本形 ここから
		while (right - left > 1) {
			long mid = left + (right - left) / 2;
			if (f(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// 二分探索の基本形 ここまで

		// 上記のwhileループを抜けた時点で、leftとrightが隣合せ、かつ、
		// f(left)がfalseでf(right)がtrueになっている

		// 確認用
//		System.out.println("すべての商品を" + left + "円以下にはできないが");
//		System.out.println("すべての商品を" + right + "円以下にはできることが分かった");

		// すべての商品をright円以下にしたときの各価格を求める
		int ticket = m;
		for (int i = 0; i < n; i++) {
			result[i] = input[i];
			while (right < result[i]) {
				ticket--;
				result[i] /= 2;
			}
		}

		// 確認用
//		System.out.println("割引前" + Arrays.toString(input));
//		System.out.println("割引後" + Arrays.toString(result));

		// 余った割引券は使う ※ここの割引券の使い方が正しい自信がない
		if (ticket != 0) {
			Arrays.sort(result);
			for (int i = n - 1; i >= 0; i--) {
				ticket--;
				result[i] /= 2;
				if (ticket == 0) {
					break;
				}
			}
		}

		// 確認用
//		System.out.println("割引後" + Arrays.toString(result));

		// 答えを求めて出力
		long cost = 0;
		for (int i = 0; i < n; i++) {
			cost += result[i];
		}
		System.out.println(cost);

	}

	// すべての商品をborder円以下にできるか？
	static boolean f(long border) {

		int ticket = m;
		for (int i = 0; i < n; i++) {
			result[i] = input[i];
			while (border < result[i]) {
				ticket--;
				result[i] /= 2;
				if (ticket < 0) {
					return false;
				}
			}
		}

		return true;
	}
}
