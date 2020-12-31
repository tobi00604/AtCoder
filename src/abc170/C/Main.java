package abc170.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		Integer target = new Integer(Integer.parseInt(sc.next()));
		int n = Integer.parseInt(sc.next()); // 禁止リストの長さ

		// 禁止リストがない場合は目標がそのまま答え
		if (n == 0) {
			System.out.println(target);
			return;
		}

		// 入力（続き）
		Integer x[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			x[i] = new Integer(Integer.parseInt(sc.next()));
		}

		// 目標が禁止されていない場合は目標がそのまま答え
		if (!Arrays.asList(x).contains(target)) {
			System.out.println(target);
			return;
		}

		// ソート
		Arrays.sort(x);
		// System.out.println(Arrays.toString(x));

		// 目標は禁止リストの何番目？
		int index = Arrays.asList(x).indexOf(target);

		// 左方向に答えを探していく
		int now = target.intValue();
		int minus = 0;
		while (now <= x[x.length - 1].intValue()) {

			// １歩く
			minus++;

			// そこは？
			now = target.intValue() - minus;
			// System.out.println("ここは" + now);

			// 禁止リストにない数に到達したらwhileループを抜ける
			if (!Arrays.asList(x).contains(new Integer(now))) {
				break;
			}
		}

		// 右方向に答えを探していく
		now = target.intValue();
		int plus = 0;
		while (x[0].intValue() <= now) {

			// １歩く
			plus++;

			// そこは？
			now = target.intValue() + plus;
			// System.out.println("ここは" + now);

			// 禁止リストにない数に到達したらwhileループを抜ける
			if (!Arrays.asList(x).contains(new Integer(now))) {
				break;
			}
		}

		// System.out.println(minus + " " + target + " " + plus);

		// 最も近いほうを出力
		if (minus <= plus) {
			System.out.println(target.intValue() - minus);
		} else {
			System.out.println(target.intValue() + plus);
		}

	}
}
