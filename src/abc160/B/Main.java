package abc160.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long x = Long.parseLong(sc.next());

		long result = 0;

		// ‚È‚é‚×‚­500‰~‹Ê‚ğì‚é
		result += (x / 500) * 1000;
		x = x % 500;

		// 5‰~‹Ê‚ğì‚é
		result += (x / 5) * 5;

		System.out.println(result);

	}
}
