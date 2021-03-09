package abc194.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// ‘S’Tõ
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cost = (i == j) ? a[i] + b[j] : Math.max(a[i], b[j]);
//				System.out.println(i + " " + j + " " + cost);
				minCost = Math.min(minCost, cost);
			}
		}

		System.out.println(minCost);

	}
}
