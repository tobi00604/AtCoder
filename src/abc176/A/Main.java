package abc176.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int t = Integer.parseInt(sc.next());

		int time = 0;
		while (true) {
			time += t;
			n -= x;
			if (n <= 0) {
				break;
			}
		}

		System.out.println(time);

	}
}
