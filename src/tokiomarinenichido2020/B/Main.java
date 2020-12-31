package tokiomarinenichido2020.B;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		idea2();
	}

	// これで提出したら不正解だった…原因は不明
	private static void idea1() {

		// 入力
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long v = sc.nextInt();
		long b = sc.nextInt();
		long w = sc.nextInt();
		long t = sc.nextInt();

		// 子Bの逃げる速さが、鬼Aと同速かそれ以上だったら、永遠に追いつけない
		if (v <= w) {
			System.out.println("NO");
			return;
		}

		// ２人の距離は１秒にどれくらい縮まるか？
		long speed = v - w;

		// ２人は最初どのくらい離れているか？
		long dis = (a < b) ? (b - a) : (a - b);

		// 追いつくのに何秒かかるか？
		long need = dis / speed;

		// t秒以内に追いつけたらYES
		System.out.println((need <= t) ? "YES" : "NO");

	}

	private static void idea2() {

		// 入力
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long v = sc.nextInt();
		long b = sc.nextInt();
		long w = sc.nextInt();
		long t = sc.nextInt();

		// ２人は最初どのくらい離れているか？
		long dis = (a < b) ? (b - a) : (a - b);

		for (int i = 1; i <= t; i++) {
			// ふたりの距離を更新
			dis = dis - v + w;

			// 追いついたらYES
			if (dis <= 0) {
				System.out.println("YES");
				return;
			}

		}

		System.out.println("NO");

	}

}
