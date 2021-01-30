package abc190.C;

import java.util.*;

// ���H�߂�����ނ����ˁH�Ǝv�����琧�񂪏������̂Ńr�b�g�S�T���ł��邗
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}
		int k = Integer.parseInt(sc.next());
		int[] c = new int[k];
		int[] d = new int[k];
		for (int i = 0; i < k; i++) {
			c[i] = Integer.parseInt(sc.next());
			d[i] = Integer.parseInt(sc.next());
		}

		// �u2��k��v�񃋁[�v
		List<Integer> dishList;
		int highScore = 0;
		for (int i = 0; i < (1 << k); i++) {

			// k�񃋁[�v
			dishList = new ArrayList<Integer>();
			for (int j = 0; j < k; j++) {
				if ((1 & i >> j) == 1) {
					// ����̃{�[��
					if (!dishList.contains(c[j])) {
						dishList.add(c[j]);
					}
					// System.out.print(c[j]);
				} else {
					// �E��̃{�[��
					if (!dishList.contains(d[j])) {
						dishList.add(d[j]);
					}
					// System.out.print(d[j]);
				}
			}

			// ���������R�b�v�̐��𐔂��悤
			int score = 0;
			for (int j = 0; j < m; j++) {
				if (dishList.contains(a[j]) && dishList.contains(b[j])) {
					score++;
				}
			}

			highScore = Math.max(highScore, score);
			// System.out.println(dishList.size() + " " + score);

		}

		System.out.println(highScore);

	}
}
