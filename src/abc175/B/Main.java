package abc175.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int l[];
		l = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = Integer.parseInt(sc.next());
		}

		int result = 0;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				for (int k = 0; k < n; k++) {

					if (i < j && j < k && l[i] != l[j] && l[j] != l[k] && l[i] != l[k]) {

//						System.out.println((i + 1) + " " + (j + 1) + " "
//								+ (k + 1));

						int x[];
						x = new int[3];
						x[0] = l[i];
						x[1] = l[j];
						x[2] = l[k];
						Arrays.sort(x);
//						System.out.println(x[0] + " " + x[1] + " " + x[2]);

						if (x[0] + x[1] > x[2]) {
							result++;
//							System.out.println("yes");
						} else {
//							System.out.println("no");
						}
					}

				}
			}
		}
		System.out.println(result);

	}
}
