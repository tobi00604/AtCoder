package m_solutions2020.D;

import java.util.*;

// 解説を読んでからやってみた
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] p = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = Long.parseLong(sc.next());
		}

		// 所持金と所持株
		long money = 1000;
		long kabu = 0;

		for (int i = 0; i < n; i++) {

			// まず全部売る
			money += p[i] * kabu;
			kabu = 0;

			// 明日のほうが高いときは全財産かけて買う
			if (i != n - 1 && p[i] < p[i + 1]) {
				long kau = money / p[i];
				money -= kau * p[i];
				kabu += kau;
			}
		}

		System.out.println(money);

	}

}
