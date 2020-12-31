package abc185.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Integer.parseInt(sc.next());

		System.out.println(calc(n - 12, 12));
	}

	// �݂�������l���ŕ�����Ƃ��A���ʂ肩���߂�֐�
	// �� calc(7, 3)��7�݂̂����3�l�ŕ����遨36�ʂ�
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
