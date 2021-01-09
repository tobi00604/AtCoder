package abc130.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int yoko = Integer.parseInt(sc.next());
		int tate = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// –ÊÏ
		double p = (long) yoko * (long) tate * 0.5;
		int q = (x * 2 == yoko) && (y * 2 == tate) ? 1 : 0;
		System.out.println(p + " " + q);
	}
}
