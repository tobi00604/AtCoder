package abc187.D;

import java.util.*;

// 解説を読んでからやってみた
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Town[] t = new Town[n];
		long aoki = 0;
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			t[i] = new Town(a, b);

			// 青木の票数を数えておく
			aoki += a;
		}

		// ソートの規則を作ってソート
		Comparator<Town> c = new Comparator<Town>() {
			public int compare(Town t1, Town t2) {
				return (t2.aab - t1.aab > 0) ? 1 : -1;
			}
		};
		Arrays.sort(t, c);

		// 確認用
		// for (int i = 0; i < n; i++) {
		// System.out.println(t[i].aab);
		// }

		// ひとつの市で演説すると、
		// ・青木がA票減る
		// ・高橋がA+B票増える
		// ので、2A+Bが大きい町から演説していく
		int result = 0;
		long takahasi = 0;
		for (int i = 0; i < n; i++) {

			result++;
			aoki -= t[i].a;
			takahasi += t[i].a + t[i].b;

			if (aoki < takahasi) {
				System.out.println(result);
				return;
			}

		}

	}

	// ひとつの町
	static class Town {

		long a;
		long b;
		long aab;

		// コンストラクタ
		public Town(long a, long b) {
			this.a = a;
			this.b = b;
			this.aab = a + a + b;
		}

	}
}
