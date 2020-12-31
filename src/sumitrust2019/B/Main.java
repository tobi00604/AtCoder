package sumitrust2019.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());

		for (int i = 0; i < 50000; i++) {
			int x = i * 108;
			x /= 100;
			// System.out.println(i + " " + x);
			if (x == a) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(":(");

	}
}
