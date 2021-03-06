package arc112.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		long[] left = new long[t];
		long[] right = new long[t];
		for (int i = 0; i < t; i++) {
			left[i] = Long.parseLong(sc.next());
			right[i] = Long.parseLong(sc.next());
		}

		for (int query = 0; query < t; query++) {

			long l = left[query];
			long r = right[query];

			// 山の数
			long h = r - (l * 2) + 1;

			// 一つも作れない場合もある
			if (h <= 0) {
				System.out.println(0);
				continue;
			}

			// 1+2+3+...+h を計算すればいいのでは
			long sum = h * (h + 1) / 2;
			System.out.println(sum);

		}

	}
}
