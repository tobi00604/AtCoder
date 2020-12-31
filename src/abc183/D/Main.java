package abc183.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long w = Long.parseLong(sc.next());
		int[] s = new int[n];
		int[] t = new int[n];
		long[] p = new long[n];

		long[] x = new long[200002]; // ù—v‚Ì‘Œ¸
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(sc.next());
			t[i] = Integer.parseInt(sc.next());
			p[i] = Integer.parseInt(sc.next());

			x[s[i]] += p[i];
			x[t[i]] -= p[i];
		}

		// –ˆ•ª‚Ìù—v‚ğ’²‚×‚Ä‚İ‚é
		long y = 0;
		for (int i = 0; i <= 200000; i++) {
			y += x[i];
			if (w < y) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}
}
