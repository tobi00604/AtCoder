package abc171.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long sum = 0;
		int v[];
		v = new int[100001];
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(sc.next());

			// 数列の総和と、各数字の登場回数を保持しておく
			sum += x;
			v[x]++;
		}

		// 各クエリ
		int q = Integer.parseInt(sc.next());
		for (int i = 0; i < q; i++) {

			// 入力
			int b = Integer.parseInt(sc.next()); // 置換前
			int c = Integer.parseInt(sc.next()); // 置換後

			// 総和の更新
			sum += (c - b) * v[b];

			// 登場回数の更新
			v[c] += v[b];
			v[b] = 0;

			// 上記方法でやることで、総和を求めるのがO(1)で済む。

			// 結果出力
			System.out.println(sum);
		}

	}
}
