package abc193.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// 2から100001まで調べていく
		long resultCount = 0;
		boolean[] skip = new boolean[100002];
		Arrays.fill(skip, false);
		for (long i = 2; i <= 100001; i++) {

			// skip対象ならスキップしていい
			if (skip[(int) i]) {
				continue;
			}

			// 数えていく
			for (long j = 2; j <= 35; j++) {
				long x = (long) Math.pow((double) i, (double) j);

				// 今後同じ数を調べないようskip対象に追加
				if (x <= 100001) {
					skip[(int) x] = true;
				}

				if (x <= n) {
					resultCount++;
				} else {
					break;
				}
			}
		}

		System.out.println(n - resultCount);

	}
}
