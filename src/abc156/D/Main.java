package abc156.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long x1 = Long.parseLong(sc.next());
		long x2 = Long.parseLong(sc.next());

		// 計算
		long mod = 1000000000 + 7;
		long all = modPow(2, n, mod);
		x1 = modCombination(n, x1, mod);
		x2 = modCombination(n, x2, mod);

		// 答え
		long result = (all - 1 - x1 - x2) % mod;
		result += (result < 0) ? mod : 0; // modして負になったらmodを足す
		System.out.println(result);

	}

	// aのn乗をmodして返す
	static long modPow(long a, long n, long mod) {
		long result = 1;
		while (n > 0) {
			if ((n & 1) == 1) {
				result = result * a % mod;
			}
			a = a * a % mod;
			n >>= 1; // nを半減
		}
		return result;
	}

	// nＣrをmodして返す
	static long modCombination(long n, long r, long mod) {
		long bunsi = n;
		long bunbo = r;
		for (long i = 1; i < r; i++) {
			bunsi = (bunsi * (n - i)) % mod;
			bunbo = (bunbo * i) % mod;
		}
		return bunsi * modPow(bunbo, mod - 2, mod) % mod;
		// ↑補足。mod(10^9+7)の世界では、「bunboで割ること」と
		// 「bunboの(10^9+7-2)乗をかけること」は等価。
	}
}
