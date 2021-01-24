package abc159.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		if (n <= 1) {
			System.out.println(m * (m - 1) / 2);
			return;
		}

		if (m <= 1) {
			System.out.println(n * (n - 1) / 2);
			return;
		}

		System.out.println((n * (n - 1) / 2) + (m * (m - 1) / 2));
	}
}
