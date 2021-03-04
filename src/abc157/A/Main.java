package abc157.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		// “š‚¦
		System.out.println((n % 2 == 1 ? n + 1 : n) / 2);
	}
}