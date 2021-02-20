package abc141.D;

import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] input;
	static int[] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		input = new int[n];
		result = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(sc.next());
		}

		// �R�[�i�[�P�[�X 0�~�Ŕ����Ă��܂��ꍇ
		if (f(0)) {
			System.out.println(0);
			return;
		}

		// �񕪒T���̏����l
		long left = 0; // f(0)��false
		long right = Long.MAX_VALUE; // f(��)��true

		// �񕪒T���̊�{�` ��������
		while (right - left > 1) {
			long mid = left + (right - left) / 2;
			if (f(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// �񕪒T���̊�{�` �����܂�

		// ��L��while���[�v�𔲂������_�ŁAleft��right���׍����A���A
		// f(left)��false��f(right)��true�ɂȂ��Ă���

		// �m�F�p
//		System.out.println("���ׂĂ̏��i��" + left + "�~�ȉ��ɂ͂ł��Ȃ���");
//		System.out.println("���ׂĂ̏��i��" + right + "�~�ȉ��ɂ͂ł��邱�Ƃ���������");

		// ���ׂĂ̏��i��right�~�ȉ��ɂ����Ƃ��̊e���i�����߂�
		int ticket = m;
		for (int i = 0; i < n; i++) {
			result[i] = input[i];
			while (right < result[i]) {
				ticket--;
				result[i] /= 2;
			}
		}

		// �m�F�p
//		System.out.println("�����O" + Arrays.toString(input));
//		System.out.println("������" + Arrays.toString(result));

		// �]�����������͎g�� �������̊������̎g���������������M���Ȃ�
		if (ticket != 0) {
			Arrays.sort(result);
			for (int i = n - 1; i >= 0; i--) {
				ticket--;
				result[i] /= 2;
				if (ticket == 0) {
					break;
				}
			}
		}

		// �m�F�p
//		System.out.println("������" + Arrays.toString(result));

		// ���������߂ďo��
		long cost = 0;
		for (int i = 0; i < n; i++) {
			cost += result[i];
		}
		System.out.println(cost);

	}

	// ���ׂĂ̏��i��border�~�ȉ��ɂł��邩�H
	static boolean f(long border) {

		int ticket = m;
		for (int i = 0; i < n; i++) {
			result[i] = input[i];
			while (border < result[i]) {
				ticket--;
				result[i] /= 2;
				if (ticket < 0) {
					return false;
				}
			}
		}

		return true;
	}
}
