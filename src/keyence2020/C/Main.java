package keyence2020.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			result.append((i < k) ? s : (s + 1) % (1000000000));
			if (i != n - 1) {
				result.append(" ");
			}
		}

		System.out.println(result);
	}
}
