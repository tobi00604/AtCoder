package abc192.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		if (n % 100 == 0) {
			System.out.println(100);
		} else {
			System.out.println(100 - (n % 100));
		}

	}
}
