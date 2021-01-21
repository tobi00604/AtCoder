package abc160.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String x = sc.next();

		System.out.println((x.charAt(2) == x.charAt(3) && x.charAt(4) == x
				.charAt(5)) ? "Yes" : "No");

	}
}
