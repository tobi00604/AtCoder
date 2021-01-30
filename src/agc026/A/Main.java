package agc026.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		int cost = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i + 1]) {
				cost++;
				a[i + 1] = 999;
			}
		}

		System.out.println(cost);

	}
}
