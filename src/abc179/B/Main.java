package abc179.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int best = 0;
		int ren = 0;
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			ren = (a == b) ? (ren + 1) : (0);

			if (best <= ren) {
				best = ren;
			}
		}

		System.out.println(best >= 3 ? "Yes" : "No");
	}
}
