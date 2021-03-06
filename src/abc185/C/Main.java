package abc185.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Integer.parseInt(sc.next());

		System.out.println(calc(n - 12, 12));
	}

	// みかんを何人かで分けるとき、何通りか求める関数
	// 例 calc(7, 3)→7個のみかんを3人で分ける→36通り
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
