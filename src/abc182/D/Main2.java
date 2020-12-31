package abc182.D;

import java.math.BigInteger;
import java.util.*;

// おもいついた解法その２
// longだと足りない？さっきのをBigIntegerで書き換えてみよう
// 残り時間もわずかだし他の解法も特に思いつかないので
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}

		// 累積和 b
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				b[i] = a[i];
			} else {
				b[i] = b[i - 1] + a[i];
			}
		}

		// 累積和の累積和 c
		BigInteger[] c = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				c[i] = BigInteger.valueOf(a[i]);
			} else {
				c[i] = c[i - 1].add(BigInteger.valueOf(b[i]));
			}
		}

		// bの最大値
		long maxB = 0;
		for (int i = 0; i < n; i++) {
			if (maxB < b[i]) {
				maxB = b[i];
			}
		}

		// c（ただし末尾以外）の最大値
		BigInteger maxC = BigInteger.ZERO;
		for (int i = 0; i < n - 1; i++) {
			if (maxC.compareTo(c[i]) == -1) {
				maxC = c[i];
			}
		}

		// 出力
		System.out.println(maxC.longValue() + maxB);

		// 以下デバッグ用なのでコメントアウト
		// for (int i = 0; i < n; i++) {
		// System.out.println(c[i] + "_" + b[i] + "_" + a[i]);
		// }
		// System.out.println(maxC + " " + maxB);

	}
}
