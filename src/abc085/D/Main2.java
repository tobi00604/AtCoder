package abc085.D;

import java.util.*;

// �������̒�o��WA�������̂ŉ��PDF��ǂ�ł��܂����B
// �E������Ƌ�������S�������Ă���A�U��Ƌ�������U�葱����A�Ƃ����헪�͐����������I
// �E�������̒�o�ł͓����铁�̃\�[�g��Y��Ă����B�C�������B���x����AC�Ȃ邩�H
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int hp = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// a�̒��̍ō��З͂����߂�
		int maxA = 0;
		for (int i = 0; i < n; i++) {
			maxA = Math.max(a[i], maxA);
		}

		// ����ȍ~�A�����Ă�maxA���ア���͈�؎g��Ȃ�

		// ���ׂĂ̓����܂�������
		Arrays.sort(b);
		int result = 0;
		for (int i = n - 1; 0 <= i; i--) {
			if (maxA < b[i]) {
				result++;
				hp -= b[i];
				if (hp <= 0) {
					System.out.println(result);
					return;
				}
			}
		}

		// ���Ƃ�maxA��U�葱����
		result += hp / maxA + (hp % maxA != 0 ? 1 : 0);
		System.out.println(result);
	}
}
