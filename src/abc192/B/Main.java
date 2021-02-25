package abc192.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				String str = s.charAt(i) + "";
				String str2 = str.toLowerCase();
				if (str.equals(str2)) {
					System.out.println("No");
					return;
				}
			} else {
				String str = s.charAt(i) + "";
				String str2 = str.toUpperCase();
				if (str.equals(str2)) {
					System.out.println("No");
					return;
				}
			}
		}

		System.out.println("Yes");
	}
}
