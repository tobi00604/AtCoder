package arc110.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long a = 1;
		for (long i = 2; i <= n; i++) {
			a = a * i / gcd(i, a);
		}
		System.out.println(a + 1);
	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}
