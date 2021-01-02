package abc187.D;

import java.util.*;

// �������i���y�[�W�ɂ�����o�͗�P����AC�ɂȂ�Ȃ��j�������������Ȃ̂Œ�o�B
// �E�\�[�g�����������iz[]�ɏd���l������̂�TreeMap���g����킯���Ȃ��j
// �E�����ǂނƂ����������������Ⴄ�i�񕪒T���Ȃ�Ă���ĂȂ��j
public class Main {

	static int n;
	static int[] x;
	static int[] y;
	static long[] rui1;
	static long[] rui2;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		x = new int[n];
		y = new int[n];
		int[] z = new int[n]; // �\�[�g�p
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
			y[i] = Integer.parseInt(sc.next());
			z[i] = x[i] + y[i];
		}

		// TreeMap���o�R���邱�ƂŁAz�̃\�[�g�ɘA��������x��y���\�[�g
		Map<Integer, Integer> mapX = new TreeMap<>();
		Map<Integer, Integer> mapY = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			mapX.put(z[i], x[i]);
			mapY.put(z[i], y[i]);
		}
		int index = n - 1;
		for (int v : mapX.values()) {
			x[index] = v;
			index--;
		}
		index = n - 1;
		for (int v : mapY.values()) {
			y[index] = v;
			index--;
		}

		// �ݐϘa������Ă���
		rui1 = new long[n];
		rui1[0] = x[0] + y[0];
		for (int i = 0 + 1; i < n; i++) {
			rui1[i] = rui1[i - 1] + x[i] + y[i];
		}
		rui2 = new long[n];
		rui2[n - 1] = x[n - 1];
		for (int i = n - 1 - 1; i >= 0; i--) {
			rui2[i] = rui2[i + 1] + x[i];
		}

		// �m�F�p
//		for (int i = 0; i < n; i++) {
//			System.out.println(x[i] + " $ " + y[i]);
//		}
//		System.out.println(Arrays.toString(rui1));
//		System.out.println(Arrays.toString(rui2));

		// �񕪒T���̏����l
		int left = 0; // f(0)��false
		int right = n; // f(�s�̐�)��true

		// �񕪒T���̊�{�`�@��������
		while (right - left > 1) {
			int mid = left + (right - left) / 2;
			if (f(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		// �񕪒T���̊�{�`�@�����܂�

		// ��L��while���[�v�𔲂������_�ŁAleft��right���׍����A���A
		// f(left)��false��f(right)��true�ɂȂ��Ă���

		// �����right�����̂܂܏o��
		System.out.println(right);

	}

	// x��̉����ŏ��Ă邩�H
	static boolean f(int en) {

		// �������܂��������Ȃ��ƕ���
		if (en == 0) {
			return false;
		}

		// �S�Ă̎s�ŉ�������Ə���
		if (en == n) {
			return true;
		}

		long taka = rui1[en - 1];
		long aoki = rui2[en];

		return aoki < taka;
	}
}
