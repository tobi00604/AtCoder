package panasonic2020.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());

		// ��a�{��b����c �����ό`����� 4ab��(c-a-b)^2 �ɂȂ萮�����m�Ŕ�r�ł���B
		// ����̖��̐���ł� a �� b �� 10^9 ����̂�long�ł͑���Ȃ��B

		BigInteger left = BigInteger.valueOf(4).multiply(BigInteger.valueOf(a))
				.multiply(BigInteger.valueOf(b));
		BigInteger right = BigInteger.valueOf(c - a - b).multiply(
				BigInteger.valueOf(c - a - b));

		// left �� right ��菬�����ꍇ�� -1�A�������ꍇ�� 0�A�傫���ꍇ�� 1
		System.out.println(left.compareTo(right) == -1 ? "Yes" : "No");

	}
}
