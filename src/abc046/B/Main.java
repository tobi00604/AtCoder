package abc046.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		long result = k;
		for (int i = 1; i < n; i++) {
			result *= (k - 1);
		}
		System.out.println(result);

	}
}
