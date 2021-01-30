package agc025.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int minCost = 9999999;
		for (int i = 1; i < n; i++) {
			int j = n - i;

			int p = 0; // i‚ÌŠeŒ…‚Ì˜a
			p += (i / 100000) % 10;
			p += (i / 10000) % 10;
			p += (i / 1000) % 10;
			p += (i / 100) % 10;
			p += (i / 10) % 10;
			p += (i / 1) % 10;

			int q = 0; // j‚ÌŠeŒ…‚Ì˜a
			p += (j / 100000) % 10;
			p += (j / 10000) % 10;
			p += (j / 1000) % 10;
			p += (j / 100) % 10;
			p += (j / 10) % 10;
			p += (j / 1) % 10;

			minCost = Math.min(minCost, p + q);
		}

		System.out.println(minCost);

	}
}
