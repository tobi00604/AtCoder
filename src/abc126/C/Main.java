package abc126.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next()); // サイコロの面数
		long goal = Long.parseLong(sc.next()); // 目標点数

		double result = 0;
		for (int i = 1; i <= n; i++) {

			// iは、何度「2倍」するとgoalに届くか？
			int kaisuu = 0;
			int score = i;
			while (score < goal) {
				kaisuu++;
				score *= 2;
			}

			// i点からゴールできる確率をresultに足す
			result += 1.0 / Math.pow(2, kaisuu);

		}

		System.out.println(result / (n + 0.0));

	}
}
