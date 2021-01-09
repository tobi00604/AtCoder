package abc180.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long a = 0;
		long b = 0;
		long c = 0;
		for (int i = 0; i < n; i++) {
			long x = Long.parseLong(sc.next());
			a += Math.abs(x);
			b += x * x;
			c = Math.max(Math.abs(x), c);
		}

		System.out.println(a);
		System.out.println((double) Math.sqrt((double) b));
		System.out.println(c);

	}
}
