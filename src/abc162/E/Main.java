package abc162.E;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 要素数n個の配列
		int array[];
		array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = 1;

		int cnt = 0;
		while (true) {

			cnt++;

			// 今回処理する配列
			System.out.println(Arrays.toString(array));

			// 配列のアイテムすべての最大公約数
			int gcd = getGcd(array);
			System.out.println(" " + gcd);

			// 配列のアイテムを１ヶ所、１増やす
			int i;
			for (i = 0; i < n; i++) {
				if (array[i] < k) {
					array[i]++;
					if (i != 0) {
						for (int j = 0; j < i; j++) {
							array[j] = 1;
						}
					}

					break;
				}
			}

			// もう増やすところがなくなったらプログラム終了
			if (i == n) {
				break;
			}

		}

		System.out.println(cnt + " LOOPS!");
		return;

	}

	public static int getGcd(int array[]) {

		if (array.length == 2) {
			return getTwoGcd(array[0], array[1]);
		} else {
			int partArray[];
			partArray = new int[array.length - 1];
			for (int i = 0; i < partArray.length; i++) {
				partArray[i] = array[i];
			}
			return getTwoGcd(getGcd(partArray),array[array.length-1]);
		}
	}

	public static int getTwoGcd(int m, int n) {

		int r;
		while (n > 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
}
