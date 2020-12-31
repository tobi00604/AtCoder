package abc177.D;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int friends[];
		friends = new int[n + 1];

		// ���͂�z��Ɏ���
		long line[];
		line = new long[m];
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			line[i] = Math.min(a, b) * 1000000 + Math.max(a, b);
		}
		Arrays.sort(line);

		// friends[77]�ɂ͏o�Ȕԍ�77�Ԃ̐l�̗F�B�̐�������
		for (int i = 0; i < m; i++) {

			// �s�v�ȏ��ł���΃X�L�b�v
			if (i != 0 && line[i] == line[i - 1]) {
				continue;
			}

			friends[(int) (line[i] / 1000000)]++;
			friends[(int) (line[i] % 1000000)]++;
		}

		// �m�F�p
		// for (int i = 0; i < n + 1; i++) {
		// System.out.println(i + " " + friends[i]);
		// }

		// �ł��F�B�������l�́A���l�F�B�����邩�H
		int best = 0;
		for (int i = 0; i < n + 1; i++) {
			if (best < friends[i]) {
				best = friends[i];
			}
		}

		// �ł��F�B�������l�́A�F�B�̐���500�l��������A501�O���[�v�ɕ��f����
		System.out.println(best + 1);

	}
}
