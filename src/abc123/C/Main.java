package abc123.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long a[];
		a = new long[5];
		a[0] = Long.parseLong(sc.next());
		a[1] = Long.parseLong(sc.next());
		a[2] = Long.parseLong(sc.next());
		a[3] = Long.parseLong(sc.next());
		a[4] = Long.parseLong(sc.next());

		// �ł��A���l���̏��Ȃ���蕨�́A�A���l����min�Ƃ���
		long min = a[0];
		for (int i = 1; i <= 4; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}

		// min�l�������̂�
		System.out.println((long) ((n - 0.1) / min) + 5);

	}
}
