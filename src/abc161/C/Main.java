package abc161.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long k = Long.parseLong(sc.next());

		System.out.println(Math.min(n % k, k - (n % k)));
	}
}
