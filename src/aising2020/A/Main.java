package aising2020.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());

		int result = 0;
		for (int i = a; i <= b; i++) {
			if (i % c == 0) {
				result++;
			}
		}

		System.out.println(result);

	}
}
