package abc125.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// 足し算していく
		long result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] < 0) {
				a[i] = -a[i];
				a[i + 1] = -a[i + 1];
			}
			result += a[i];
		}

		// 最後の数が正なら、足し算して終了
		if (0 <= a[n - 1]) {
			System.out.println(result + a[n - 1]);
			return;
		}

		// 最後の数が負なら、それを正に変えて足したあと、
		// 絶対値が最も小さい数を探してきて２回引く
		result += -a[n - 1];
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, Math.abs(a[i]));
		}
		System.out.println(result - min * 2);

	}
}
