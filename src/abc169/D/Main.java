package abc169.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// n��1�������瓚����0�Ŋm��
		if (n == 1) {
			System.out.println(0);
			return;
		}

		// n��f��������
		HashMap<Long, Long> map = primeFactorize(n);

		// �f���������̌��ʕ\��
		for (long key : map.keySet()) {
			// System.out.println(key + "^" + map.get(key));
		}

		// ���ʂ����߂ďo��
		int result = 0;
		for (long key : map.keySet()) {
			long z = map.get(key);
			for (int j = 1; j < 10000; j++) {
				if (j <= z) {
					z -= j;
					result++;
				} else {
					break;
				}
			}
		}

		System.out.println(result);

	}

	// n��f�����������āA���ʗpmap�ɑf�����Ǝw���̃y�A�����ĕԂ��֐��B
	public static HashMap<Long, Long> primeFactorize(long n) {

		long input = n;
		HashMap<Long, Long> map = new HashMap<Long, Long>();

		// n��0�ȉ���������null��Ԃ�
		if (n <= 0) {
			return null;
		}

		// �{���͂����������͂����An��1��������f�����������ʂ�1^1�Ƃ���
		if (n == 1) {
			map.put(1L, 1L);
			return map;
		}

		// �f�����������Ă����B�v�Z�ʂ�O(��n)
		for (long i = 2; i * i <= input; i++) {
			long j = 0;
			while (true) {
				if (n % i == 0) {
					j++;
					map.put(i, j);
					n /= i;
				} else {
					break;
				}
			}
		}

		// �Ō�Ɏc���������Y�ꂸ�ɓ����
		if (n != 1) {
			map.put(n, 1L);
		}

		return map;
	}
}