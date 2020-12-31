package abc170.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		Integer target = new Integer(Integer.parseInt(sc.next()));
		int n = Integer.parseInt(sc.next()); // �֎~���X�g�̒���

		// �֎~���X�g���Ȃ��ꍇ�͖ڕW�����̂܂ܓ���
		if (n == 0) {
			System.out.println(target);
			return;
		}

		// ���́i�����j
		Integer x[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			x[i] = new Integer(Integer.parseInt(sc.next()));
		}

		// �ڕW���֎~����Ă��Ȃ��ꍇ�͖ڕW�����̂܂ܓ���
		if (!Arrays.asList(x).contains(target)) {
			System.out.println(target);
			return;
		}

		// �\�[�g
		Arrays.sort(x);
		// System.out.println(Arrays.toString(x));

		// �ڕW�͋֎~���X�g�̉��ԖځH
		int index = Arrays.asList(x).indexOf(target);

		// �������ɓ�����T���Ă���
		int now = target.intValue();
		int minus = 0;
		while (now <= x[x.length - 1].intValue()) {

			// �P����
			minus++;

			// �����́H
			now = target.intValue() - minus;
			// System.out.println("������" + now);

			// �֎~���X�g�ɂȂ����ɓ��B������while���[�v�𔲂���
			if (!Arrays.asList(x).contains(new Integer(now))) {
				break;
			}
		}

		// �E�����ɓ�����T���Ă���
		now = target.intValue();
		int plus = 0;
		while (x[0].intValue() <= now) {

			// �P����
			plus++;

			// �����́H
			now = target.intValue() + plus;
			// System.out.println("������" + now);

			// �֎~���X�g�ɂȂ����ɓ��B������while���[�v�𔲂���
			if (!Arrays.asList(x).contains(new Integer(now))) {
				break;
			}
		}

		// System.out.println(minus + " " + target + " " + plus);

		// �ł��߂��ق����o��
		if (minus <= plus) {
			System.out.println(target.intValue() - minus);
		} else {
			System.out.println(target.intValue() + plus);
		}

	}
}
