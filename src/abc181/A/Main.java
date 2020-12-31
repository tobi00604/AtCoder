package abc181.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		System.out.println(n % 2 == 1 ? "Black" : "White");
	}
}
