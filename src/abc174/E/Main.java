package abc174.E;

import java.util.*;

public class Main {

	static int n;
	static int k;
	static int[] logs;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		k = Integer.parseInt(sc.next());
		logs = new int[n];
		for (int i = 0; i < n; i++) {
			logs[i] = Integer.parseInt(sc.next());
		}

		// 二分探索の初期値
		int left = 0; // f(0)はfalse
		int right = 2147483647; // f(2147483647)はtrue

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

	// k回の切断ですべての丸太をtarget以下の長さにできるか？
	static boolean f(int target) {

		// コーナーケース
		if (target <= 0) {
			return false;
		}

		// 今回使えるノコギリの本数
		int knife = k;

		for (int i = 0; i < n; i++) {

			// 切断しなくていい丸太はスキップ
			if (logs[i] <= target) {
				continue;
			}

			// ノコギリを消費して切断していく
			// 例：丸太の長さが9で目標が4なら2回切断
			knife -= logs[i] / target;

			// ノコギリが途中で不足したらfalse
			if (knife < 0) {
				return false;
			}
		}

		return true;
	}
}
