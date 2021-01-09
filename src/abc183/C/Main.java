package abc183.C;

import java.util.*;

public class Main {

	// 問題サイズ
	public static int n;

	// すべての道順を入れるリスト
	public static ArrayList<String> tour;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		long k = Integer.parseInt(sc.next());
		long t[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				t[i][j] = Integer.parseInt(sc.next());
			}
		}

		// ありえる道順の列挙を得る
		tour = new ArrayList<String>();
		saiki("0");

		// それぞれの道順について
		int result = 0;
		for (String str : tour) {
			long cost = 0;

			// 交通費を求める
			for (int i = 0; i < n - 1; i++) {
				int from = Integer.parseInt(str.charAt(i) + "");
				int to = Integer.parseInt(str.charAt(i + 1) + "");
				cost += t[from][to];
			}

			// 最後に帰ってくる交通費も忘れずに足す
			int from = Integer.parseInt(str.charAt(n - 1) + "");
			int to = 0;
			cost += t[from][to];

			// 結果出力用
			if (cost == k) {
				result++;
			}
		}

		System.out.println(result);

	}

	public static void saiki(String value) {

		// 道順をリストに入れて再帰打ち切り
		if (value.length() == n) {
			tour.add(value);
			return;
		}

		// 次へ
		for (int i = 0; i < n; i++) {

			// すでに言った都市はスキップ
			if (value.contains(i + "")) {
				continue;
			}

			saiki(value + i);
		}
	}
}
