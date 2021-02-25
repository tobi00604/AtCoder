package keyence2020.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());

		if (n % Math.max(h, w) == 0) {
			System.out.println(0 + (n / Math.max(h, w)));
		} else {
			System.out.println(1 + (n / Math.max(h, w)));
		}
	}
}
