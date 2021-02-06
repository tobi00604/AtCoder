package abc062.C;

import java.util.*;

// チョコ３等分問題
public class Main {

	static long result;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long h = Long.parseLong(sc.next());
		long w = Long.parseLong(sc.next());

		// ３等分できる場合はする
		if (h % 3 == 0 || w % 3 == 0) {
			System.out.println(0);
			return;
		}

		result = Long.MAX_VALUE;

		// 上をちぎって残りを割る方針
		for (long tate = 1; tate <= (h / 2) + 1; tate++) {

			long c1 = tate * w;
			long c2;
			long c3;

			// 残りを等分できる場合
			if ((h - tate) % 2 == 0 || w % 2 == 0) {
				c2 = (h - tate) * w / 2;
				c3 = h * w - c1 - c2;
				f(c1, c2, c3);
				continue;
			}

			// 残りを横切り
			c2 = ((h - tate + 1) / 2) * w;
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);

			// 残りを縦切り
			c2 = (h - tate) * ((w + 1) / 2);
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);
		}

		// 左をちぎって残りを割る方針（hとwを取り換えればＯＫ）
		long temp = h;
		h = w;
		w = temp;
		for (long tate = 1; tate <= (h / 2) + 1; tate++) {

			long c1 = tate * w;
			long c2;
			long c3;

			// 残りを等分できる場合
			if ((h - tate) % 2 == 0 || w % 2 == 0) {
				c2 = (h - tate) * w / 2;
				c3 = h * w - c1 - c2;
				f(c1, c2, c3);
				continue;
			}

			// 残りを横切り
			c2 = ((h - tate + 1) / 2) * w;
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);

			// 残りを縦切り
			c2 = (h - tate) * ((w + 1) / 2);
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);
		}

		System.out.println(result);

	}

	// 与えられた３つのチョコ面積から、目的関数の値を計算
	static void f(long c1, long c2, long c3) {
		long maxChoco = Math.max(c1, Math.max(c2, c3));
		long minChoco = Math.min(c1, Math.min(c2, c3));
		result = Math.min(result, maxChoco - minChoco);
	}
}
