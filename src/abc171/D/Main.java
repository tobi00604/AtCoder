package abc171.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long sum = 0;
		int v[];
		v = new int[100001];
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(sc.next());

			// ����̑��a�ƁA�e�����̓o��񐔂�ێ����Ă���
			sum += x;
			v[x]++;
		}

		// �e�N�G��
		int q = Integer.parseInt(sc.next());
		for (int i = 0; i < q; i++) {

			// ����
			int b = Integer.parseInt(sc.next()); // �u���O
			int c = Integer.parseInt(sc.next()); // �u����

			// ���a�̍X�V
			sum += (c - b) * v[b];

			// �o��񐔂̍X�V
			v[c] += v[b];
			v[b] = 0;

			// ��L���@�ł�邱�ƂŁA���a�����߂�̂�O(1)�ōςށB

			// ���ʏo��
			System.out.println(sum);
		}

	}
}
