package abc194.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());

		if (a + b >= 15 && b >= 8) {
			System.out.println(1);
			return;
		}

		if (a + b >= 10 && b >= 3) {
			System.out.println(2);
			return;
		}

		if (a + b >= 3) {
			System.out.println(3);
			return;
		}

		System.out.println(4);

	}
}
