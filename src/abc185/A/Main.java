package abc185.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long c = Long.parseLong(sc.next());
		long d = Long.parseLong(sc.next());

		System.out.println(Math.min(Math.min(a, b), Math.min(c, d)));

	}
}
