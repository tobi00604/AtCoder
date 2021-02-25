package abc124.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int cost1 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				cost1 += (s.charAt(i) == '0') ? 1 : 0;
			} else {
				cost1 += (s.charAt(i) == '1') ? 1 : 0;
			}
		}

		int cost2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				cost2 += (s.charAt(i) == '1') ? 1 : 0;
			} else {
				cost2 += (s.charAt(i) == '0') ? 1 : 0;
			}
		}

		System.out.println(Math.min(cost1, cost2));

	}
}
