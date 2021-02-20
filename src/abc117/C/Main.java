package abc117.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] x = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(x);

		// �R�[�i�[�P�[�X ���u�������ŃQ�[�����I���ꍇ
		if (m <= n) {
			System.out.println(0);
			return;
		}

		// �e��Ԃ̒������v��
		int[] dist = new int[m - 1];
		for (int i = 0; i < m - 1; i++) {
			dist[i] = x[i + 1] - x[i];
		}
		Arrays.sort(dist);

		// n�̋����̂� n-1 �����̋�Ԃ͒ʂ�Ȃ��Ă���
		int result = 0;
		for (int i = 0; i < m - 1 - (n - 1); i++) {
			result += dist[i];
		}
		System.out.println(result);

	}
}
