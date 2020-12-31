package abc185.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Integer.parseInt(sc.next());

		System.out.println(calc(n - 12, 12));
	}

	// ‚İ‚©‚ñ‚ğ‰½l‚©‚Å•ª‚¯‚é‚Æ‚«A‰½’Ê‚è‚©‹‚ß‚éŠÖ”
	// —á calc(7, 3)¨7ŒÂ‚Ì‚İ‚©‚ñ‚ğ3l‚Å•ª‚¯‚é¨36’Ê‚è
	static long calc(long mikan, long hito) {
		BigInteger a = BigInteger.valueOf(1);
		BigInteger b = BigInteger.valueOf(1);
		for (long i = 1; i < hito; i++) {
			a = a.multiply(BigInteger.valueOf(mikan + hito - i));
			b = b.multiply(BigInteger.valueOf(i));
		}
		BigInteger r = a.divide(b);
		//r = r.remainder(BigInteger.valueOf(1000000007));
		return r.longValue();
	}
}
