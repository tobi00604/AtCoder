package abc162.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ®”
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long result = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 3 != 0 && i % 5 != 0)
				result += i;
		}

		System.out.println(result);

	}

}
