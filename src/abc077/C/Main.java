package abc077.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		// System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(b));
		// System.out.println(Arrays.toString(c));

		// �T��
		long resultTotal = 0;
		for (int ib = 0; ib < n; ib++) {

			// ��̒i
			long resultA = 0;
			int left = 0; // f(0)��true
			int right = n - 1; // f(n-1)��false
			if (a[n - 1] < b[ib]) {
				// �R�[�i�[�P�[�X(�S��true)
				resultA = n;
			} else if (b[ib] <= a[0]) {
				// �R�[�i�[�P�[�X(�S��false)
				resultA = 0;
			} else {
				// �񕪒T��
				while (right - left > 1) {
					int mid = left + (right - left) / 2;
					if (a[mid] >= b[ib]) {
						right = mid;
					} else {
						left = mid;
					}
				}
				// ��L��while���[�v�𔲂������_�ŁAleft��right���׍����A���A
				// f(left)��true��f(right)��false�ɂȂ��Ă���
				resultA = left + 1;
			}

			// ��̒i
			long resultB = 0;
			left = 0; // f(0)��false
			right = n - 1; // f(n-1)��true
			if (c[n - 1] <= b[ib]) {
				// �R�[�i�[�P�[�X(�S��false)
				resultB = 0;
			} else if (c[0] > b[ib]) {
				// �R�[�i�[�P�[�X(�S��true)
				resultB = n;
			} else {
				// �񕪒T��
				while (right - left > 1) {
					int mid = left + (right - left) / 2;
					if (c[mid] > b[ib]) {
						right = mid;
					} else {
						left = mid;
					}
				}
				// ��L��while���[�v�𔲂������_�ŁAleft��right���׍����A���A
				// f(left)��false��f(right)��true�ɂȂ��Ă���
				resultB = n - left - 1;
			}

			resultTotal += resultA * resultB;
		}

		System.out.println(resultTotal);

	}
}