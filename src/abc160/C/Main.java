package abc160.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		int max = a[0] + (k - a[n - 1]);
		for (int i = 1; i < n; i++) {
			max = Math.max(max, a[i] - a[i - 1]);
		}

		System.out.println(k - max);

	}
}
