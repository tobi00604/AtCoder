package abc158.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		long loop = n / (a + b);
		long result = loop * a;

		long amari = n % (a + b);

		System.out.println(result + Math.min(amari, a));
	}
}
