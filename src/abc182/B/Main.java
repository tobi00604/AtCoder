package abc182.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(sc.next());
		}

		int bestscore = 0;
		int bestnumber = 0;
		for (int p = 2; p <= 1000; p++) {

			int score = 0;
			for (int i = 0; i < n; i++) {
				if (array[i] % p == 0) {
					score++;
				}
			}

			//System.out.println(p + " " + score);

			if (bestscore <= score) {
				bestnumber = p;
				bestscore = score;
			}
		}

		System.out.println(bestnumber);

	}
}
