package abc055.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		long m = Long.parseLong(sc.next());

		long result = 1;

		long hou = 1000000007;
		for (int i = 1; i <= m; i++) {
			result *= i;
			result %= hou;
		}
		
		System.out.println(result);

	}
}
