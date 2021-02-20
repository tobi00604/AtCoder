package abc137.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		StringBuilder[] input = new StringBuilder[n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int[] a = new int[10];
			for (int j = 0; j < 10; j++) {
				a[j] = str.charAt(j);
			}
			Arrays.sort(a);
			input[i] = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				input[i].append("_");
				input[i].append(a[j]);
			}

		}
		Arrays.sort(input);

		// “š‚¦‚ð‹‚ß‚é
		long result = 0;
		long point = 1;
		StringBuilder sb = new StringBuilder(input[0]);
		for (int i = 1; i < n; i++) {
			if (sb.toString().contentEquals(input[i])) {
				point++;
			} else {
				result += point * (point - 1) / 2;
				point = 1;
				sb = input[i];
			}
		}
		result += point * (point - 1) / 2;
		System.out.println(result);

	}
	
}