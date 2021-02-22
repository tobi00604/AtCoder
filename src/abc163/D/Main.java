package abc163.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// �R�[�i�[�P�[�X
		if (n + 1 == k) {
			System.out.println(1);
			return;
		}

		long hou = 1000000000 + 7;
		long result = 0;
		for (int mai = k; mai <= n + 1; mai++) {

			// ����a�ōŏ��̂��̂ƍő�̂���
			long minWa = getSum(0, mai - 1);
			long maxWa = getSum(n - mai + 1, n);

			// mai���Ƃ����Ƃ��ɍ���̂�pat�ʂ�
			long pat = maxWa - minWa + 1;
			pat %= hou;
			result += pat;
			result %= hou;
		}

		System.out.println(result);
	}

	static long getSum(long from, long to) {
		return (from + to) * (to - from + 1) / 2;
	}
}
