package abc187.D;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Town[] t = new Town[n];
		long aoki = 0;
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			t[i] = new Town(a, b);

			// �؂̕[���𐔂��Ă���
			aoki += a;
		}

		// �\�[�g�̋K��������ă\�[�g
		Comparator<Town> c = new Comparator<Town>() {
			public int compare(Town t1, Town t2) {
				return (t2.aab - t1.aab > 0) ? 1 : -1;
			}
		};
		Arrays.sort(t, c);

		// �m�F�p
		// for (int i = 0; i < n; i++) {
		// System.out.println(t[i].aab);
		// }

		// �ЂƂ̎s�ŉ�������ƁA
		// �E�؂�A�[����
		// �E������A+B�[������
		// �̂ŁA2A+B���傫�������牉�����Ă���
		int result = 0;
		long takahasi = 0;
		for (int i = 0; i < n; i++) {

			result++;
			aoki -= t[i].a;
			takahasi += t[i].a + t[i].b;

			if (aoki < takahasi) {
				System.out.println(result);
				return;
			}

		}

	}

	// �ЂƂ̒�
	static class Town {

		long a;
		long b;
		long aab;

		// �R���X�g���N�^
		public Town(long a, long b) {
			this.a = a;
			this.b = b;
			this.aab = a + a + b;
		}

	}
}
