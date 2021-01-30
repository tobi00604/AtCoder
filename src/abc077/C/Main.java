package abc077.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
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

		// 探索
		long resultTotal = 0;
		for (int ib = 0; ib < n; ib++) {

			// 上の段
			long resultA = 0;
			int left = 0; // f(0)はtrue
			int right = n - 1; // f(n-1)はfalse
			if (a[n - 1] < b[ib]) {
				// コーナーケース(全部true)
				resultA = n;
			} else if (b[ib] <= a[0]) {
				// コーナーケース(全部false)
				resultA = 0;
			} else {
				// 二分探索
				while (right - left > 1) {
					int mid = left + (right - left) / 2;
					if (a[mid] >= b[ib]) {
						right = mid;
					} else {
						left = mid;
					}
				}
				// 上記のwhileループを抜けた時点で、leftとrightが隣合せ、かつ、
				// f(left)がtrueでf(right)がfalseになっている
				resultA = left + 1;
			}

			// 上の段
			long resultB = 0;
			left = 0; // f(0)はfalse
			right = n - 1; // f(n-1)はtrue
			if (c[n - 1] <= b[ib]) {
				// コーナーケース(全部false)
				resultB = 0;
			} else if (c[0] > b[ib]) {
				// コーナーケース(全部true)
				resultB = n;
			} else {
				// 二分探索
				while (right - left > 1) {
					int mid = left + (right - left) / 2;
					if (c[mid] > b[ib]) {
						right = mid;
					} else {
						left = mid;
					}
				}
				// 上記のwhileループを抜けた時点で、leftとrightが隣合せ、かつ、
				// f(left)がfalseでf(right)がtrueになっている
				resultB = n - left - 1;
			}

			resultTotal += resultA * resultB;
		}

		System.out.println(resultTotal);

	}
}