package panasonic2020.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());

		int[] f = { 1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1,
				5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51 };

		System.out.println(f[a - 1]);

	}
}
