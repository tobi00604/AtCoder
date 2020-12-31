package abc161.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int point[] = new int[n];
		for (int i = 0; i < n; i++) {
			point[i] = sc.nextInt();
		}

		// ソート（ただし昇順になることに注意）
		Arrays.sort(point);

		// 総投票数
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += point[i];
		}

		// 人気 m 位のアイテムの票数によって分岐
		if (point[point.length - m] * m * 4 < sum) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}

	}

}
