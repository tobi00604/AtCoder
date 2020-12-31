package abc174.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long d = Integer.parseInt(sc.next());

		int result = 0;
		for (int i = 0; i < n; i++) {

			long x = Integer.parseInt(sc.next());
			long y = Integer.parseInt(sc.next());

			if ((x * x) + (y * y) <= (d * d)) {
				result++;
			}

		}

		System.out.println(result);

	}
}
