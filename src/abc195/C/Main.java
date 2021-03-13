package abc195.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		if (n <= 999) {
			System.out.println(0);
			return;
		}

		long result = 0;

		result += n - 1000L + 1;
		if (n <= 999999L) {
			System.out.println(result);
			return;
		}

		result += n - 1000000L + 1;
		if (n <= 999999999L) {
			System.out.println(result);
			return;
		}

		result += n - 1000000000L + 1;
		if (n <= 999999999999L) {
			System.out.println(result);
			return;
		}

		result += n - 1000000000000L + 1;
		if (n <= 999999999999999L) {
			System.out.println(result);
			return;
		}

		result += n - 1000000000000000L + 1;
		if (n <= 999999999999999999L) {
			System.out.println(result);
			return;
		}

	}
}
