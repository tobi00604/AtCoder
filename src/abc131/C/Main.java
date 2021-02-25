package abc131.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long c = Long.parseLong(sc.next());
		long d = Long.parseLong(sc.next());
		long e = lcm(c, d);

		// aˆÈãbˆÈ‰º‚Ì®”‚ÅAc‚Å‚àd‚Å‚àŠ„‚èØ‚ê‚È‚¢‚à‚Ì‚ÌŒÂ”‚ğ‹‚ß‚é

		// aˆÈã‚Ì®”‚ÅÅ¬‚ÌAŠ„‚èØ‚ê‚é‚à‚Ì
		long minC = (a % c == 0) ? a : (a / c) * c + c;
		long minD = (a % d == 0) ? a : (a / d) * d + d;
		long minE = (a % e == 0) ? a : (a / e) * e + e;
//		System.out.println(minC + ", " + minD + ", " + minE);

		// bˆÈ‰º‚Ì®”‚ÅÅ‘å‚ÌAŠ„‚èØ‚ê‚é‚à‚Ì
		long maxC = (b % c == 0) ? b : (b / c) * c;
		long maxD = (b % d == 0) ? b : (b / d) * d;
		long maxE = (b % e == 0) ? b : (b / e) * e;
//		System.out.println(maxC + ", " + maxD + ", " + maxE);

		// Š„‚èØ‚ê‚é‚à‚Ì‚ÌŒÂ”
		long cntC = (minC <= maxC) ? (maxC / c) - (minC / c) + 1 : 0;
		long cntD = (minD <= maxD) ? (maxD / d) - (minD / d) + 1 : 0;
		long cntE = (minE <= maxE) ? (maxE / e) - (minE / e) + 1 : 0;
//		System.out.println(cntC + ", " + cntD + ", " + cntE);

		// “š‚¦
		System.out.println(b - a + 1 - cntC - cntD + cntE);

	}

	// 2‚Â‚Ì”‚ÌÅ‘åŒö–ñ”‚ğ•Ô‚·
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// 2‚Â‚Ì”‚ÌÅ¬Œö”{”‚ğ•Ô‚·
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
}
