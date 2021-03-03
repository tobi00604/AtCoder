package abc157.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// �S�T��
		for (int result = 0; result <= 999; result++) {

			// result��N��
			String s = result + "";
			if (s.length() != n) {
				continue;
			}

			// ������a[i]���ڂ�b[i]
			boolean okFlag = true;
			for (int i = 0; i < m; i++) {
				String x = s.charAt(a[i] - 1) + "";
				String y = b[i] + "";
				if (!x.equals(y)) {
					okFlag = false;
					break;
				}
			}

			if (okFlag) {
				System.out.println(result);
				return;
			}

		}

		System.out.println(-1);

	}
}
