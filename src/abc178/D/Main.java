package abc178.D;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.next());

		// 皿何枚まで考慮すればいいか？
		int maxDish = s / 3;

		// 皿の数を増やしながら答えを求めて足していく
		long result = 0;
		for (int dish = 1; dish <= maxDish; dish++) {
			result += calc(s - (dish * 3), dish);
			result = result % 1000000007;
		}

		System.out.println(result);
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
		r = r.remainder(BigInteger.valueOf(1000000007));
		return r.longValue();
	}
}
