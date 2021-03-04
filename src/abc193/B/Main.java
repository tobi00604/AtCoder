package abc193.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] p = new int[n];
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			p[i] = Integer.parseInt(sc.next());
			x[i] = Integer.parseInt(sc.next());
		}

		int minCost = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (a[i] < x[i]) {
				minCost = Math.min(minCost, p[i]);
			}
		}

		System.out.println(minCost != Integer.MAX_VALUE ? minCost : -1);

	}
}
