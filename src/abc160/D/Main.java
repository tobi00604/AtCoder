package abc160.D;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// �ŒZ�o�H��k�ƂȂ�悤�ȓ��͂������邩�H�Ƃ�����肾���A
		// ������悭����Ɩ��T�C�Y���������̂�
		// �n�_�ƏI�_�̃y�A���ׂĂ̍ŒZ�o�H�����߂Ă��Ԃɍ����B

		int[] result = new int[n];
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {

				// �����g��Ȃ������Ƃ��̋���
				int l1 = j - i;

				// ����X����Y�֌������Ēʂ����Ƃ��̋���
				int l2 = 1;
				l2 += Math.abs(x - i);
				l2 += Math.abs(y - j);

				// ����Y����X�֌������Ēʂ����Ƃ��̋���
				int l3 = 1;
				l3 += Math.abs(y - i);
				l3 += Math.abs(x - j);

				// �ŒZ�����������L�^
				result[Math.min(Math.min(l1, l2), l3)]++;

			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(result[i]);
		}

	}
}
