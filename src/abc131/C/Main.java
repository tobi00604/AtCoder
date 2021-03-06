package abc131.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long c = Long.parseLong(sc.next());
		long d = Long.parseLong(sc.next());
		long e = lcm(c, d);

		// a以上b以下の整数で、cでもdでも割り切れないものの個数を求める

		// a以上の整数で最小の、割り切れるもの
		long minC = (a % c == 0) ? a : (a / c) * c + c;
		long minD = (a % d == 0) ? a : (a / d) * d + d;
		long minE = (a % e == 0) ? a : (a / e) * e + e;
//		System.out.println(minC + ", " + minD + ", " + minE);

		// b以下の整数で最大の、割り切れるもの
		long maxC = (b % c == 0) ? b : (b / c) * c;
		long maxD = (b % d == 0) ? b : (b / d) * d;
		long maxE = (b % e == 0) ? b : (b / e) * e;
//		System.out.println(maxC + ", " + maxD + ", " + maxE);

		// 割り切れるものの個数
		long cntC = (minC <= maxC) ? (maxC / c) - (minC / c) + 1 : 0;
		long cntD = (minD <= maxD) ? (maxD / d) - (minD / d) + 1 : 0;
		long cntE = (minE <= maxE) ? (maxE / e) - (minE / e) + 1 : 0;
//		System.out.println(cntC + ", " + cntD + ", " + cntE);

		// 答え
		System.out.println(b - a + 1 - cntC - cntD + cntE);

	}

	// 2つの数の最大公約数を返す
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// 2つの数の最小公倍数を返す
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
}
