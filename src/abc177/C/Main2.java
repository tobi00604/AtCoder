package abc177.C;

import java.math.BigInteger;
import java.util.*;

public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long array[];
		array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = Long.parseLong(sc.next());
		}

		BigInteger sum = BigInteger.ZERO;
		BigInteger tate = BigInteger.ZERO;
		BigInteger yoko = BigInteger.ZERO;
		for (int i = 0; i < n - 1; i++) {
			tate = tate.add(BigInteger.valueOf(array[i]));
			yoko = BigInteger.valueOf(array[i + 1]);
			sum = sum.add(tate.multiply(yoko));
		}

		sum = sum.remainder(BigInteger.valueOf(1000000007));

		System.out.println(sum);

	}
}
