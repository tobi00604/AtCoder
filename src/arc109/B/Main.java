package arc109.B;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// “Á—á
		if (n == 2) {
			System.out.println(1);
			return;
		}

		long l, r;
		l = 1;
		r = n;

		while (r - l > 1) {
			long mid = l + (r - l) / 2;
			// System.out.println(l + " ` " + r);
			// System.out.println(" " + mid + ":" + func(n, mid));
			if (func(n, mid)) {
				r = mid;
			} else {
				l = mid;
			}
		}

		System.out.println(r);

	}

	// n–{‚ÌŠÛ‘¾‚ğm‰~‚Å’B¬‚Å‚«‚é‚©‚Ç‚¤‚©”»’è
	static boolean func(long n, long m) {

		long cut = n + 1; // ¡‚©‚çØ‚éŠÛ‘¾‚Ì’·‚³
		long need = n - m + 1; // Ø‚Á‚Äì‚éŠÛ‘¾‚Ì–{”

		BigInteger a = BigInteger.valueOf(need);
		a = a.multiply(BigInteger.valueOf(need + 1));
		a = a.divide(BigInteger.valueOf(2));
		a = a.subtract(BigInteger.valueOf(cut));

		// ’·‚³‚ª‘«‚è‚é‚È‚çtrue, ‘«‚è‚È‚¢‚È‚çfalse
		return a.compareTo(BigInteger.ZERO) != 1;

		// return need * (need + 1) / 2 <= cut;

	}
}
