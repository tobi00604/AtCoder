package abc086.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		int x = Integer.parseInt(a + "" + b);

		for (int i = 1; i <= 1000; i++) {
			if (i * i == x) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}
}
