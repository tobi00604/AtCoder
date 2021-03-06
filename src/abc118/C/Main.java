package abc118.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// 答え
		System.out.println(gcd(a));

	}

	// 2つの数の最大公約数を返す
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// 配列aの各要素の最大公約数を返す
	static long gcd(int[] a) {
		long result = a[0];
		for (int i = 0; i < a.length; i++) {
			result = gcd(result, (long) a[i]);
		}
		return result;
	}
}
