package abc195.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int total = Integer.parseInt(sc.next()) * 1000;

		int x1;
		if (total % b == 0) {
			x1 = total / b;
		} else {
			x1 = (total / b) + 1;
		}

		int x2;
		if (total % a == 0) {
			x2 = total / a;
		} else {
			x2 = (total / a);
		}

		if (x1 <= x2) {
			System.out.println(x1 + " " + x2);
		} else {
			System.out.println("UNSATISFIABLE");
		}

	}
}
