package m_solutions2020.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		for (int i = 0; i < k; i++) {

			if (b <= a) {
				b *= 2;
				continue;
			}

			if (c <= b) {
				c *= 2;
				continue;
			}

		}

		if (a < b && b < c) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
