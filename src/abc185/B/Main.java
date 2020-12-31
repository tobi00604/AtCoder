package abc185.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long z_max = Long.parseLong(sc.next());
		int m = Integer.parseInt(sc.next());
		long t_fin = Long.parseLong(sc.next());
		long[] a = new long[m];
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			a[i] = Long.parseLong(sc.next());
			b[i] = Long.parseLong(sc.next());
		}

		long z = z_max;
		long t = 0;
		for (int i = 0; i < m; i++) {

			// カフェ到着
			z = z - (a[i] - t);
			t = a[i];
			//System.out.println(t + " " + z);

			if (z <= 0) {
				System.out.println("No");
				return;
			}

			// 充電
			z = Math.min(z + (b[i] - a[i]), z_max);
			t = b[i];
			//System.out.println(t + " " + z);

		}

		// 帰宅
		z = z - (t_fin - t);
		t = t_fin;
		//System.out.println(t + " " + z);

		if (z <= 0) {
			System.out.println("No");
			return;
		}

		System.out.println("Yes");

	}
}
