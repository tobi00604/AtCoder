package abc062.C;

import java.util.*;

// �`���R�R�������
public class Main {

	static long result;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long h = Long.parseLong(sc.next());
		long w = Long.parseLong(sc.next());

		// �R�����ł���ꍇ�͂���
		if (h % 3 == 0 || w % 3 == 0) {
			System.out.println(0);
			return;
		}

		result = Long.MAX_VALUE;

		// ����������Ďc���������j
		for (long tate = 1; tate <= (h / 2) + 1; tate++) {

			long c1 = tate * w;
			long c2;
			long c3;

			// �c��𓙕��ł���ꍇ
			if ((h - tate) % 2 == 0 || w % 2 == 0) {
				c2 = (h - tate) * w / 2;
				c3 = h * w - c1 - c2;
				f(c1, c2, c3);
				continue;
			}

			// �c������؂�
			c2 = ((h - tate + 1) / 2) * w;
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);

			// �c����c�؂�
			c2 = (h - tate) * ((w + 1) / 2);
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);
		}

		// �����������Ďc���������j�ih��w����芷����΂n�j�j
		long temp = h;
		h = w;
		w = temp;
		for (long tate = 1; tate <= (h / 2) + 1; tate++) {

			long c1 = tate * w;
			long c2;
			long c3;

			// �c��𓙕��ł���ꍇ
			if ((h - tate) % 2 == 0 || w % 2 == 0) {
				c2 = (h - tate) * w / 2;
				c3 = h * w - c1 - c2;
				f(c1, c2, c3);
				continue;
			}

			// �c������؂�
			c2 = ((h - tate + 1) / 2) * w;
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);

			// �c����c�؂�
			c2 = (h - tate) * ((w + 1) / 2);
			c3 = h * w - c1 - c2;
			f(c1, c2, c3);
		}

		System.out.println(result);

	}

	// �^����ꂽ�R�̃`���R�ʐς���A�ړI�֐��̒l���v�Z
	static void f(long c1, long c2, long c3) {
		long maxChoco = Math.max(c1, Math.max(c2, c3));
		long minChoco = Math.min(c1, Math.min(c2, c3));
		result = Math.min(result, maxChoco - minChoco);
	}
}
