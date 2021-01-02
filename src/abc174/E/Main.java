package abc174.E;

import java.util.*;

public class Main {

	static int n;
	static int k;
	static int[] logs;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		k = Integer.parseInt(sc.next());
		logs = new int[n];
		for (int i = 0; i < n; i++) {
			logs[i] = Integer.parseInt(sc.next());
		}

		// �񕪒T���̏����l
		int left = 0; // f(0)��false
		int right = 2147483647; // f(2147483647)��true

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

	// k��̐ؒf�ł��ׂĂ̊ۑ���target�ȉ��̒����ɂł��邩�H
	static boolean f(int target) {

		// �R�[�i�[�P�[�X
		if (target <= 0) {
			return false;
		}

		// ����g����m�R�M���̖{��
		int knife = k;

		for (int i = 0; i < n; i++) {

			// �ؒf���Ȃ��Ă����ۑ��̓X�L�b�v
			if (logs[i] <= target) {
				continue;
			}

			// �m�R�M��������Đؒf���Ă���
			// ��F�ۑ��̒�����9�ŖڕW��4�Ȃ�2��ؒf
			knife -= logs[i] / target;

			// �m�R�M�����r���ŕs��������false
			if (knife < 0) {
				return false;
			}
		}

		return true;
	}
}
