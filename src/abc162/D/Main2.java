package abc162.D;

import java.util.*;

// 前回の提出はナイーブな解法でTLEだったので
// 解説を読んでからやってみた
public class Main2 {

	public static void main(String[] args) {

		// 整数
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String str = sc.next();

		// コーナーケース
		if (n < 3) {
			System.out.println(0);
			return;
		}

		// 条件１を満たすが条件２を満たさないものをカウント
		long result1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// iとjの値からkは自然に決まる
				int k = j + j - i;
				if (n <= k) {
					continue;
				}

				// カウント
				char ci = str.charAt(i);
				char cj = str.charAt(j);
				char ck = str.charAt(k);
				if (ci != cj && cj != ck && ck != ci) {
					result1++;
				}
			}
		}

		// 条件１を満たすものをカウント
		long result2 = 0;
		long i1 = 0;
		long i2 = 0;
		long i3 = 0;
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (c == 'R') {
				i1++;
			}
			if (c == 'G') {
				i2++;
			}
			if (c == 'B') {
				i3++;
			}
		}
		result2 = i1 * i2 * i3;

		// 条件１を満たして条件２も満たすものを出力
		System.out.println(result2 - result1);

	}

}
