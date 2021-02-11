package abc157.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int[] b = new int[9];
		for (int i = 0; i < 9; i++) {
			b[i] = Integer.parseInt(sc.next());
		}
		int n = Integer.parseInt(sc.next());
		for (int i = 0; i < n; i++) {
			int call = Integer.parseInt(sc.next());
			for (int j = 0; j < 9; j++) {
				if (b[j] == call) {
					b[j] = 0;
				}
			}
		}

		// 0 1 2
		// 3 4 5
		// 6 7 8

		// ”»’è
		String result = "No";
		if (b[0] == 0 && b[1] == 0 && b[2] == 0) {
			result = "Yes";
		}
		if (b[3] == 0 && b[4] == 0 && b[5] == 0) {
			result = "Yes";
		}
		if (b[6] == 0 && b[7] == 0 && b[8] == 0) {
			result = "Yes";
		}
		if (b[0] == 0 && b[3] == 0 && b[6] == 0) {
			result = "Yes";
		}
		if (b[1] == 0 && b[4] == 0 && b[7] == 0) {
			result = "Yes";
		}
		if (b[2] == 0 && b[5] == 0 && b[8] == 0) {
			result = "Yes";
		}
		if (b[0] == 0 && b[4] == 0 && b[8] == 0) {
			result = "Yes";
		}
		if (b[2] == 0 && b[4] == 0 && b[6] == 0) {
			result = "Yes";
		}

		System.out.println(result);
	}
}