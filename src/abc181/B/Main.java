package abc181.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long sum = 0;
		for (int i = 0; i < n; i++) {

			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());

			long temp1 = 0;
			long temp2 = 0;

			if (b % 2 == 0) {
				temp1 = b / 2;
				temp1 *= (b + 1);
			} else {
				temp1 = (b + 1) / 2;
				temp1 *= b;
			}

			if (a % 2 == 0) {
				temp2 = a / 2;
				temp2 *= (a - 1);
			} else {
				temp2 = (a - 1) / 2;
				temp2 *= a;
			}

			// System.out.println(temp1 + " " + temp2);
			sum += temp1 - temp2;

		}

		System.out.println(sum);
	}
}
