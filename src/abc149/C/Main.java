package abc149.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		for (int i = x; i < x + 100; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				return;
			}
		}

	}

	// ‘f””»’è
	static boolean isPrime(int num) {

		if (num < 2)
			return false;
		else if (num == 2)
			return true;
		else if (num % 2 == 0)
			return false;

		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
