package abc065.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next()); // ��
		long m = Long.parseLong(sc.next()); // ��

		// ���Ȃ�
		if (2 <= Math.abs(n - m)) {
			System.out.println(0);
			return;
		}

		// n!��m!
		long nk = f(n) % 1000000007;
		long mk = f(m) % 1000000007;

		long result = (nk * mk) % 1000000007;
		result = (n == m) ? 2 * result % 1000000007 : result;
		System.out.println(result);
	}

	static long f(long n) {

		long result = 1;
		for (long i = 1; i <= n; i++) {
			result *= i;
			result %= 1000000007;
		}
		return result;
	}
}
