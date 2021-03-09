package abc148.E;

import java.util.*;

// 入出力例3がうまくいかないのでWAになるけどいったん提出
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// 参考
		for (int i = 1; i <= 32; i++) {
			System.out.println(i + "_" + f(i) + "_" + countZero(f(i)));
		}

		// nが奇数だと 0 で確定
		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}

		// 【メモ１】
		// nが10未満の偶数だと0
		// nが20未満の偶数だと1
		// nが30未満の偶数だと2
		// …
		// nが100未満の偶数だと9
		// nが110未満の偶数だと11
		//
		// 10ごとに1増えて、100ごとに1増えて、…って感じ？

		// 【メモ２】
		// str.substring(3, 8)
		// 最初の8文字を取り出すが、その最初の3文字は削られ、5文字になるイメージ
		// "123456789" ⇒ "45678"

		String str = n + "";
		long result = 0;
		for (int i = 1; i <= str.length() - 1; i++) {
			result += Long.parseLong((str.substring(0, i)));
		}
		System.out.println(result);

	}

	// 【参考用】問題文どおりのf
	static long f(long n) {
		return (n < 2) ? 1 : n * f(n - 2);
	}

	// 【参考用】xの末尾に0はいくつあるか
	static long countZero(long x) {
		String s = x + "";
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(n - 1 - i) != '0') {
				return i;
			}
		}
		return -1;
	}
}
