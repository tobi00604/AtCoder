package sumitrust2019.D;

import java.util.*;

// さっき提出したのはTLEになったが、おかげでひらめいた。
// 答えが必ず1000未満になるってことは、1000通り試せばいいんじゃね？
public class Main4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String s = sc.next();

		int result = 0;
		for (int i = 000; i <= 999; i++) {

			int a = i / 100;
			int b = (i / 10) % 10;
			int c = i % 10;

			int point = 0;
			for (int j = 0; j < n; j++) {

				if (point == 0 && s.substring(j, j + 1).equals(a + "")) {
					point = 1;
				} else if (point == 1 && s.substring(j, j + 1).equals(b + "")) {
					point = 2;
				} else if (point == 2 && s.substring(j, j + 1).equals(c + "")) {
					point = 3;
				}
			}

			if (point == 3) {
				result++;
			}
		}

		System.out.println(result);

	}
}
