package abc178.C;

import java.util.*;

// コンテスト中は地道にカウントする方針でやろうとして死んだ。
// そこで本日、解説PDFどおりにやってみた（余事象の発想を使ってカウントする）。
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long hou = 1000000000 + 7;
		long a = modPow(10, n, hou);
		long b = modPow(9, n, hou);
		long c = modPow(8, n, hou);
		long d = (a - b - b + c + hou + hou) % hou;
		System.out.println(d);

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
}
