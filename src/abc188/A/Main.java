package abc188.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		System.out.println(Math.abs(a - b) < 3 ? "Yes" : "No");

	}
}
