package abc133.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long l = Long.parseLong(sc.next());
		long r = Long.parseLong(sc.next());

		// L����R�̊ԂɁu2019�̔{���v�������瓚����0
		for (long i = 0; i < 2020; i++) {
			if ((l + i) % 2019 == 0 && (l + i) <= r) {
				System.out.println(0);
				return;
			}
		}

		long a = l % 2019;
		long b = r % 2019;

		// �S�T��
		long answer = 2019;
		for (long i = a; i <= b; i++) {
			for (long j = i + 1; j <= b; j++) {
				answer = Math.min(answer, (i * j) % 2019);
			}
		}

		System.out.println(answer);

	}
}
