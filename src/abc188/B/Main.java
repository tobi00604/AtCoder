package abc188.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; i++) {
			x[i] = Long.parseLong(sc.next());
		}
		for (int i = 0; i < n; i++) {
			y[i] = Long.parseLong(sc.next());
		}

		long result = 0;
		for (int i = 0; i < n; i++) {
			result += x[i] * y[i];
		}

		System.out.println(result == 0 ? "Yes" : "No");

	}
}
