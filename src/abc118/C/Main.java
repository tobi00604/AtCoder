package abc118.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// ����
		System.out.println(gcd(a));

	}

	// 2�̐��̍ő���񐔂�Ԃ�
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// �z��a�̊e�v�f�̍ő���񐔂�Ԃ�
	static long gcd(int[] a) {
		long result = a[0];
		for (int i = 0; i < a.length; i++) {
			result = gcd(result, (long) a[i]);
		}
		return result;
	}
}
