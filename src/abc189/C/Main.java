package abc189.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] orange = new int[n];
		for (int i = 0; i < n; i++) {
			orange[i] = Integer.parseInt(sc.next());
		}

		// ’Tõ
		int high = 0;
		int highScore = 0;
		for (int l = 0; l < n; l++) {
			high = orange[l];
			for (int r = l; r < n; r++) {
				high = Math.min(high, orange[r]);
				highScore = Math.max(highScore, high * (r - l + 1));
//				System.out.println(l + "," + r + "," + high + " = " + high * (r - l + 1));
			}
		}

		// o—Í
		System.out.println(highScore);

	}
}
