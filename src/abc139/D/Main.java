package abc139.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		long result = (n % 2 == 0) ? ((n / 2) * (n - 1)) : (((n - 1) / 2) * n);
		System.out.println(result);

	}
}
