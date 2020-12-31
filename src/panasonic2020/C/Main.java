package panasonic2020.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());

		// √a＋√b＜√c を式変形すると 4ab＜(c-a-b)^2 になり整数同士で比較できる。
		// 今回の問題の制約では a も b も 10^9 あるのでlongでは足りない。

		BigInteger left = BigInteger.valueOf(4).multiply(BigInteger.valueOf(a))
				.multiply(BigInteger.valueOf(b));
		BigInteger right = BigInteger.valueOf(c - a - b).multiply(
				BigInteger.valueOf(c - a - b));

		// left が right より小さい場合は -1、等しい場合は 0、大きい場合は 1
		System.out.println(left.compareTo(right) == -1 ? "Yes" : "No");

	}
}
