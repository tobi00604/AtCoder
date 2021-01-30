package abc168.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		x %= 10;

		if (x == 3) {
			System.out.println("bon");
			return;
		}

		if (x == 0 || x == 1 || x == 6 || x == 8) {
			System.out.println("pon");
			return;
		}

		System.out.println("hon");

	}

}