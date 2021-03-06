package arc109.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int r = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// 廊下１回
		if (a == b || a == b + 1) {
			System.out.println(r);
			return;
		}

		// ひとつのビル内で１フロア上下する最短時間
		int f = Math.min(r + r, k);

		// こたえ
		if (a < b) {
			System.out.println(f * (b - a) + r);
		} else {
			System.out.println(f * (a - b - 1) + r);
		}
	}
}
