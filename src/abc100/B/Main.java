package abc100.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int d = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int a;

		if (d == 0) {
			if (n == 100) {
				a = 101;
			} else {
				a = n;
			}
		} else if (d == 1) {
			if (n == 100) {
				a = 10100;
			} else {
				a = n * 100;
			}
		} else {
			if (n == 100) {
				a = 1010000;
			} else {
				a = n * 10000;
			}
		}

		System.out.println(a);
	}
}
