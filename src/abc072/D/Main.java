package abc072.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
		}

		// “š‚¦‚ð‹‚ß‚Äo—Í
		long totalCost = 0;
		for (int i = 0; i < n - 1; i++) {
			if (p[i] == i + 1) {
				int temp = p[i];
				p[i] = p[i + 1];
				p[i + 1] = temp;
				totalCost++;
			}
		}
		if (p[n - 1] == n) {
			totalCost++;
		}
		System.out.println(totalCost);
	}
}
