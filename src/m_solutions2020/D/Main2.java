package m_solutions2020.D;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] p = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = Long.parseLong(sc.next());
		}

		// �������Ə�����
		long money = 1000;
		long kabu = 0;

		for (int i = 0; i < n; i++) {

			// �܂��S������
			money += p[i] * kabu;
			kabu = 0;

			// �����̂ق��������Ƃ��͑S���Y�����Ĕ���
			if (i != n - 1 && p[i] < p[i + 1]) {
				long kau = money / p[i];
				money -= kau * p[i];
				kabu += kau;
			}
		}

		System.out.println(money);

	}

}
