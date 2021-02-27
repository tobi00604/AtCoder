package abc158.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		for (int i = 0; i < 12345; i++) {
			if ((double) a == Math.floor((double) i * 0.08D)) {
				if ((double) b == Math.floor((double) i * 0.1D)) {
					System.out.println(i);
					return;
				}
			}
		}

		System.out.println(-1);
	}
}
