package abc044.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// ���̖����L�̉��H
		for (int i = 0; i < n; i++) {
			a[i] -= m;
		}
		m = 0;

		// �����a���i�J�[�h����ؑI�΂Ȃ��Ƃ���1�ʂ�������Ă���j
		System.out.println(new Bubunwa(a).getCount(m) - 1);

	}

	// �����a��������
	static class Bubunwa {

		private int l = 0; // DP�e�[�u���̍��[�A�܂����a�̍ŏ��l�i�S�J�[�h�̐������񕉂Ȃ�0�j
		private int r = 0; // DP�e�[�u���̉E�[�A�܂����a�̍ő�l
		private long[] count; // count[i] := �_�����a�������@�̐�

		// �R���X�g���N�^
		Bubunwa(int[] a) {

			int n = a.length; // �J�[�h�̖���
			l = 0; // DP�e�[�u���̍��[�A�܂����a�̍ŏ��l�i�S�J�[�h�̐������񕉂Ȃ�0�j
			r = 0; // DP�e�[�u���̉E�[�A�܂����a�̍ő�l
			for (int i = 0; i < n; i++) {
				if (a[i] < 0) {
					l += a[i];
				} else {
					r += a[i];
				}
			}

			// dp[i][j] := �ŏ���i���̃J�[�h�������g����j�������@�͉��ʂ肠�邩
			long[][] dp = new long[n + 1][r - l + 1];
			dp[0][-l] = 1;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= (r - l); j++) {
					dp[i][j] = dp[i - 1][j];
					if (0 <= j - a[i - 1] && j - a[i - 1] <= r - l) {
						dp[i][j] += dp[i - 1][j - a[i - 1]];
					}
				}
			}

			// ���ʂ܂Ƃ�
			count = new long[r - l + 1];
			for (int i = 0; i < r - l + 1; i++) {
				count[i] = dp[n][i];
			}

		}

		// �_�����a m �������@�̐���Ԃ�
		// ��m��0�̏ꍇ�A�J�[�h����ؑI�΂Ȃ��Ƃ���1�ʂ���܂�ł���
		long getCount(int m) {
			return count[m - l];
		}

		// �_�����a m �����邩�ǂ�����Ԃ�
		boolean canAble(int m) {
			return 0 < count[m - l];
		}

	}

}
