package joi2008yo.D;

import java.util.*;

public class Main {

	static long md = 1000002;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int m = Integer.parseInt(sc.next());
		long[] a = new long[m];
		for (int i = 0; i < m; i++) {
			long x = Long.parseLong(sc.next());
			long y = Long.parseLong(sc.next());
			a[i] = md * x + y;
		}
		int n = Integer.parseInt(sc.next());
		long[] b = new long[n];
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			long x = Long.parseLong(sc.next());
			long y = Long.parseLong(sc.next());
			b[i] = md * x + y;
			list.add(b[i]);
		}
		Arrays.sort(a);
		Arrays.sort(b);

		// �m�F�p
		// System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(b));

		// ���鐯a[0]���ǂ̐�b[i]�ɑΉ����邩�T��
		for (int i = 0; i < n; i++) {

			// ���s�ړ���
			long dx = (b[i] / md) % md - (a[0] / md) % md;
			long dy = b[i] % md - a[0] % md;

			// �m�F�p
			// System.out.println("x " + dx + " y " + dy);

			// m�̐������ׂďd�Ȃ邩�H
			boolean successFlg = true;
			for (int j = 0; j < m; j++) {
				if (!list.contains(a[j] + dx * md + dy)) {
					successFlg = false;
					break;
				}
			}
			if (successFlg) {
				System.out.println(dx + " " + dy);
				return;
			}

		}
	}
}
