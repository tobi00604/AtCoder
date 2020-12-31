package arc104.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		// x+y=a
		// x-y=b
		// 2x=a+b
		// 2y=a-b

		System.out.println(((a + b) / 2) + " " + ((a - b) / 2));
	}
}
