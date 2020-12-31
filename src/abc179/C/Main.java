package abc179.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long result = 0;
		for (int a = 1; a < n; a++) {

			if (n % a == 0) {
				result += n / a - 1;
			} else {
				result += n / a;
			}
		}

		System.out.println(result);

	}
}
