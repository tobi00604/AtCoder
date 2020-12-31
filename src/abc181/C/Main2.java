package abc181.C;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		float[] x = new float[n];
		float[] y = new float[n];
		for (int i = 0; i < n; i++) {
			x[i] = Float.parseFloat(sc.next());
			y[i] = Float.parseFloat(sc.next());
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {

					float a;
					float b;

					if (x[i] != x[j] && x[j] != x[k] && x[i] != x[k]) {
						a = (y[i] - y[j]) / (x[i] - x[j]);
						b = (y[j] - y[k]) / (x[j] - x[k]);

						if (a == b) {
							System.out.println("Yes");
							return;
						}

					} else {
						if (x[i] == x[j] && x[j] == x[k] && x[i] == x[k]) {
							System.out.println("Yes");
							return;
						}
					}

				}
			}
		}

		System.out.println("No");
	}
}
