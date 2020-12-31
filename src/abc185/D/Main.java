package abc185.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		int m = Integer.parseInt(sc.next());

		// mが0の場合は1が答え
		if (m == 0) {
			System.out.println(1);
			return;
		}

		long[] blue = new long[m];
		for (int i = 0; i < m; i++) {
			blue[i] = Long.parseLong(sc.next());
		}

		// ソート（ただし昇順になることに注意）
		Arrays.sort(blue);

		// 最も狭い隙間のサイズを探す（それが k になる）
		long k = n;
		boolean sukimaExistFlg = false;
		for (int i = 0; i <= m; i++) {
			long l = (i == 0) ? 0 : blue[i - 1];
			long r = (i == m) ? (n + 1) : blue[i];
			long sukima = r - l - 1;
			if (sukima != 0) {
				sukimaExistFlg = true;
				if (sukima < k) {
					k = sukima;
				}
			}
		}

		// 隙間がひとつもなかったらハンコ不要
		if (!sukimaExistFlg) {
			System.out.println(0);
			return;
		}

		//System.out.println("作るハンコのサイズ k は " + k);

		// 答えを求める
		long result = 0;
		for (int i = 0; i <= m; i++) {
			long l = (i == 0) ? 0 : blue[i - 1];
			long r = (i == m) ? (n + 1) : blue[i];
			long sukima = r - l - 1;
			if (sukima != 0) {
				long result_sub = sukima / k;
				if (sukima % k != 0) {
					result_sub++;
				}
				//System.out.println(sukima + "を塗るため" + result_sub + "回押しました");
				result += result_sub;
			}
		}

		// 出力
		System.out.println(result);
	}
}
