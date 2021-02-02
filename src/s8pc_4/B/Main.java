package s8pc_4.B;

import java.util.*;

// https://atcoder.jp/contests/s8pc-4/tasks/s8pc_4_b
// ���̒�o��WA�������猴�����������
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		long[] input = new long[n];
		for (int i = 0; i < n; i++) {
			input[i] = Long.parseLong(sc.next());
		}

		// n�̌����̂����A�ǂ�𑝒z���邩�H
		// ���T�C�Y���������̂� 2��n�� ���ׂĎ����B

		// �u2��n��v�񃋁[�v
		long minCost = Long.MAX_VALUE;
		for (int i = 0; i < (1 << n); i++) {

			// �ϐ�������
			long cost = 0;
			long highest = 0;
			long[] a = new long[n];
			for (int j = 0; j < n; j++) {
				a[j] = input[j];
			}

			// ���z���錚���������z���Ă���
			highest = a[0];
			for (int j = 1; j < n; j++) {
				if ((1 & i >> j) == 1 && a[j] <= highest) {
					cost += highest - a[j] + 1;
					a[j] += highest - a[j] + 1;
					highest = a[j];
				}
			}

			// �J���t�������N���A���Ă��邩�m�F
			int colorful = 0;
			highest = 0;
			for (int j = 0; j < n; j++) {
				// System.out.print(a[j]);
				if (highest < a[j]) {
					highest = a[j];
					colorful++;
				}
			}
			// System.out.println(" " + (k <= colorful) + " " + cost);

			if (k <= colorful) {
				minCost = Math.min(minCost, cost);
			}

		}

		System.out.println(minCost);
	}
}
