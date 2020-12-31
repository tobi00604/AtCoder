package abc183.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int d = Integer.parseInt(sc.next());

		float x = (float) (c - a);
		x /= (float) (b + d);
		x *= (float) b;
		x += (float) a;

		System.out.println(x);
	}
}
