package abc085.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// a+b+c=n
		// 10000a+5000b+1000c=y
		// 9000a+4000b=y-1000n

		if (y - 1000 * n < 0) {
			System.out.println("-1 -1 -1");
			return;
		}
		if (y - 1000 * n == 0) {
			System.out.println("0 0 " + n);
			return;
		}

		int t = (y / 1000) - n;

		// 9a+4b=t;
		for (int a = 0; a <= 2000; a++) {
			for (int b = 0; b <= 2000; b++) {
				if (9 * a + 4 * b == t) {
					int c = n - a - b;
					if (0 <= c) {
						System.out.println(a + " " + b + " " + c);
						return;
					}
				}
			}
		}
		System.out.println("-1 -1 -1");
	}
}
