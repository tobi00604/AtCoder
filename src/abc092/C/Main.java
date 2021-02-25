package abc092.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int l = n + 2;
		int[] a = new int[l];
		a[0] = 0;
		a[l - 1] = 0;
		for (int i = 0; i < n; i++) {
			a[1 + i] = Integer.parseInt(sc.next());
		}

		long total = 0;
		int[] dist = new int[l - 1];
		for (int i = 0; i < l - 1; i++) {
			dist[i] = Math.abs(a[i] - a[i + 1]);
			total += dist[i];
		}
		// System.out.println(Arrays.toString(dist));

		int[] dist2 = new int[l - 2];
		for (int i = 0; i < l - 2; i++) {
			dist2[i] = Math.abs(a[i] - a[i + 2]);
		}
		// System.out.println(Arrays.toString(dist2));

		int[] temp = new int[l - 2];
		for (int i = 0; i < l - 2; i++) {
			temp[i] = dist[i] + dist[i + 1];
		}
		// System.out.println(Arrays.toString(temp));

		for (int i = 0; i < l - 2; i++) {
			System.out.println(total - temp[i] + dist2[i]);
		}

	}
}
