package abc086.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] t = new int[n];
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = Integer.parseInt(sc.next());
			x[i] = Integer.parseInt(sc.next());
			y[i] = Integer.parseInt(sc.next());
		}

		// �p���e�B�������Ă��邩�m�F
		for (int i = 0; i < n; i++) {
			if (t[i] % 2 == 0) {
				if ((x[i] + y[i]) % 2 == 1) {
					System.out.println("No");
					return;
				}
			} else {
				if ((x[i] + y[i]) % 2 == 0) {
					System.out.println("No");
					return;
				}
			}
		}

		// �Ԃɍ������m�F
		for (int i = 0; i < n; i++) {

			// ��������
			int dist = 0;
			if (i == 0) {
				dist = x[0] + y[0];
			} else {
				dist = Math.abs(x[i - 1] - x[i]) + Math.abs(y[i - 1] - y[i]);
			}

			// �����Ă�������
			int time = 0;
			if (i == 0) {
				time = t[0];
			} else {
				time = t[i] - t[i - 1];
			}

			// �Ԃɍ���������
			if (time < dist) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}
}
