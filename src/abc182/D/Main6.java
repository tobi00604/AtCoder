package abc182.D;

import java.util.*;

// �����ǂ�ł������Ă݂�
// ������WA�ɂȂ��Ă��܂��c�悭�킩���
public class Main6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}

		long[] p = new long[n]; // �e��������_����n�߂��Ƃ�����ǂ��œ���I�����邩
		long[] q = new long[n]; // �e��������_����n�߂��Ƃ�����ǂ��܂ŉ����s���邩
		long[] x = new long[n]; // �e������I�����Ƃ��̃��{�b�g�̈ʒu
		p[0] = a[0];
		q[0] = (0 < a[0]) ? a[0] : 0;
		x[0] = a[0];
		// System.out.println(p[0] + " " + q[0] + " " + x[0]);
		for (int i = 1; i < n; i++) {
			p[i] = p[i - 1] + a[i];
			q[i] = (a[i] <= 0) ? q[i - 1] : Math.max(0, p[i - 1] + a[i]);
			x[i] = x[i - 1] + p[i];
			// System.out.println(p[i] + " " + q[i] + " " + x[i]);
		}

		// ���������߂�
		long result = q[0];
		for (int i = 1; i < n; i++) {
			result = Math.max(result, x[i - 1] + q[i]);
		}

		System.out.println(result);
	}
}
