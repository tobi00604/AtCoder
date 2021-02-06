package abc191.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.next());
		int t = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		int d = Integer.parseInt(sc.next());

		int a = v * t;
		int b = v * s;

		System.out.println((a <= d && d <= b) ? "No" : "Yes");

	}
}
