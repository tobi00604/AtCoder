package abc190.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		int d = Integer.parseInt(sc.next());

		boolean okFlag = false;

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());

			if (okFlag == false && x < s && d < y) {
				okFlag = true;
			}
		}

		System.out.println(okFlag ? "Yes" : "No");

	}
}
