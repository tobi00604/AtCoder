package abc190.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());

		int turn = 0;
		while (true) {

			if (turn == 0 && c == 1) {
				b--;
				if (b < 0) {
					System.out.println("Takahashi");
					return;
				}
			} else {
				a--;
				if (a < 0) {
					System.out.println("Aoki");
					return;
				}
				b--;
				if (b < 0) {
					System.out.println("Takahashi");
					return;
				}

			}

			turn++;
		}

	}
}
