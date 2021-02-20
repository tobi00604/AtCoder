package abc158.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		long a = 0;
		if (s.charAt(0) == 'A') {
			a++;
		}
		if (s.charAt(1) == 'A') {
			a++;
		}
		if (s.charAt(2) == 'A') {
			a++;
		}

		System.out.println((a == 0 || a == 3) ? "No" : "Yes");
	}
}
