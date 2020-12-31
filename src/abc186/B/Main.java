package abc186.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());

		int[] a = new int[h * w];
		for (int i = 0; i < (h * w); i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// Å¬’l‚ð’T‚·
		int min = 999;
		for (int i = 0; i < (h * w); i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}

		// “š‚¦‚ð‹‚ß‚é
		int result = 0;
		for (int i = 0; i < (h * w); i++) {
			result += (a[i] - min);
		}

		System.out.println(result);
	}
}
