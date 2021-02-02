package abc152.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int max = Integer.parseInt(sc.next());

		// 81�ʂ���ɒ��ׂđΉ��\������Ă��܂�
		int[][] table = new int[10][10];
		for (int a = 1; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {

				// 1�ȏ�max�ȉ��̐����ŁAb�Ŏn�܂���a�ŏI�����̂͂������邩
				// �����̃��[�v���d���̂�TLE�ɂȂ邩������Ȃ�
				for (int i = 1; i <= max; i++) {
					if (left(i) == b && right(i) == a) {
						table[a][b]++;
					}
				}

				// �m�F�p
				// System.out.print(table[a][b] + " ");
			}
			// System.out.println();
		}

		// �Ή��\���g���ē������o��
		int result = 0;
		for (int i = 1; i <= max; i++) {
			result += table[left(i)][right(i)];
		}
		System.out.println(result);
	}

	// �^����ꂽ�����̍��[����Ԃ��i��F314��������3�j
	static int left(int n) {
		return String.valueOf(n).charAt(0) - 48;
	}

	// �^����ꂽ�����̉E�[����Ԃ��i��F314��������4�j
	static int right(int n) {
		return n % 10;
	}
}
