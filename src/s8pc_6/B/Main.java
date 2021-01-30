package s8pc_6.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		Arrays.sort(a);
		Arrays.sort(b);

		// a�̒��Ԓl�ɓ�����u���Ab�̒��Ԓl�ɏo����u���H�i���̔��z�����������͕s���j
		int result1 = 0;
		int result2 = 0;
		if (n % 2 == 1) {
			result1 = a[n / 2];
			result2 = b[n / 2];
		} else {
			result1 = (a[n / 2] + a[n / 2 - 1]) / 2;
			result2 = (b[n / 2] + b[n / 2 - 1]) / 2;
		}

		// �������v�Z
		long total = 0;
		for (int i = 0; i < n; i++) {
			total += Math.abs(a[i] - result1);
			total += Math.abs(a[i] - b[i]);
			total += Math.abs(b[i] - result2);
		}

		System.out.println(total);
	}
}
