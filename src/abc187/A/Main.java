package abc187.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		long x = (a / 100) + ((a / 10) % 10) + (a % 10);
		long y = (b / 100) + ((b / 10) % 10) + (b % 10);

		System.out.println(Math.max(x, y));

	}
}
