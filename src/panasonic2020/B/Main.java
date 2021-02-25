package panasonic2020.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		if (a == 1 || b == 1) {
			System.out.println(1);
			return;
		}

		if ((a * b) % 2 == 1) {
			System.out.println((a * b) / 2 + 1);
		} else {
			System.out.println((a * b) / 2);
		}

	}
}
