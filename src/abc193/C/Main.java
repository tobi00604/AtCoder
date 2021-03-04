package abc193.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// 2����100001�܂Œ��ׂĂ���
		long resultCount = 0;
		boolean[] skip = new boolean[100002];
		Arrays.fill(skip, false);
		for (long i = 2; i <= 100001; i++) {

			// skip�ΏۂȂ�X�L�b�v���Ă���
			if (skip[(int) i]) {
				continue;
			}

			// �����Ă���
			for (long j = 2; j <= 35; j++) {
				long x = (long) Math.pow((double) i, (double) j);

				// ���㓯�����𒲂ׂȂ��悤skip�Ώۂɒǉ�
				if (x <= 100001) {
					skip[(int) x] = true;
				}

				if (x <= n) {
					resultCount++;
				} else {
					break;
				}
			}
		}

		System.out.println(n - resultCount);

	}
}
