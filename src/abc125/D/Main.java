package abc125.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// �����Z���Ă���
		long result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] < 0) {
				a[i] = -a[i];
				a[i + 1] = -a[i + 1];
			}
			result += a[i];
		}

		// �Ō�̐������Ȃ�A�����Z���ďI��
		if (0 <= a[n - 1]) {
			System.out.println(result + a[n - 1]);
			return;
		}

		// �Ō�̐������Ȃ�A����𐳂ɕς��đ��������ƁA
		// ��Βl���ł�����������T���Ă��ĂQ�����
		result += -a[n - 1];
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, Math.abs(a[i]));
		}
		System.out.println(result - min * 2);

	}
}
