package sumitrust2019.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		System.out.println((x % 100) <= (x / 100) * 5 ? 1 : 0);

	}
}
