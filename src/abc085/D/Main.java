package abc085.D;

import java.util.*;

// ����i�v���O�����B�Ƃ肠����Katana�N���X�Ƃ��\�[�g�Ƃ�����������B��o�͂��Ȃ��B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long hp = Long.parseLong(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		Katana[] k = new Katana[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
			k[i] = new Katana(a[i], b[i]);
		}

		// a�̒��̍ō��З͂����߂�
		int maxA = 0;
		for (int i = 0; i < n; i++) {
			maxA = Math.max(a[i], maxA);
		}

		// ���������̈З͂��������Ƀ\�[�g���Ă���
		Comparator<Katana> c = new Comparator<Katana>() {
			public int compare(Katana task1, Katana task2) {
				if (task1.b == task2.b) {
					return task2.a - task1.a;
				}
				return task2.b - task1.b;
			}
		};
		Arrays.sort(k, c);

		// �m�F�p
		System.out.println(maxA);
		for (int i = 0; i < n; i++) {
			System.out.println(k[i].toString());
		}

		// ����ȍ~�A�����Ă�maxA���ア���͈�؎g��Ȃ�

		// ���ׂĂ̓����܂�������
		int result = 0;
		for (int i = 0; i < n; i++) {
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
		while(true){
			result++;
			hp -= maxA;
			if (hp <= 0) {
				System.out.println(result);
				return;
			}
		}
	}

	static class Katana {

		int a;
		int b;

		// �R���X�g���N�^
		public Katana(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public String toString() {
			return this.a + " " + this.b;
		}
	}
}
