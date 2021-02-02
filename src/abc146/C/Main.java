package abc146.C;

import java.util.*;

//二分探索の練習。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long x = Long.parseLong(sc.next());

		// 整数屋さんに 1 から 1000000000 までの整数が売られている。
		// 整数 n の値段は、n * a + (nの桁数) * b である。
		// 現在の所持金は x である。買うことができる最大の整数を求めたい。

		int left = 0;
		int right = 1000000001;

		// 二分探索
		while (right - left > 1) {

			// 真ん中
			int mid = (right + left) / 2;
			long nedan = mid * a + (new Integer(mid)).toString().length() * b;

			// System.out.println(left + "_" + mid + "_" + right + " " + nedan);

			// 買えるか判定
			if (nedan <= x) {
				left = mid;
			} else {
				right = mid;
			}

		}

		// leftは「買える最大の整数」、rightは「買えない最小の整数」になっているはず
		System.out.println(left);

	}

}
