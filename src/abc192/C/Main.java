package abc192.C;

import java.util.*;

// どう工夫すればいいか分からん。たぶんTLEだけどナイーブな解法をまずやってみる
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		int k = Integer.parseInt(sc.next());

		// 漸化式を進んでいって答え出力
		// ただし途中で数列が収束したらそれを答えとしてよい
		for (int i = 1; i <= k; i++) {
			long next = f(n);

			if (next == n) {
				System.out.println(n);
				return;
			}

			n = next;
		}

		System.out.println(n);

	}

	static long f(long num) {

		if (num == 0) {
			return 0;
		}

		String s1 = String.valueOf(num);
		int[] a = new int[s1.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = s1.charAt(i) - 48;
		}
		Arrays.sort(a);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb1.append(a[i]);
			sb2.append(a[a.length - 1 - i]);
		}
		return Integer.parseInt(sb2.toString()) - Integer.parseInt(sb1.toString());
	}
}
