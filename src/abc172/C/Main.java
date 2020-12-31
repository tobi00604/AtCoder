package abc172.C;

import java.util.*;

public class Main {

	// 【終了後の感想】
	// なんで不正解になるのかまったくわからなくて１時間くらい無駄にしたけど、
	// Aの机とBの机の「一番上に見えている本」しか見てなかったことに後から気づく。
	// つまり無意識に "貪欲法" をやってた。このやり方だと
	//	3 4 19
	//	10 10 10
	//	11 2 2 2
	// みたいな入力のときに不正解になるわ…。
	
	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = new Integer(Integer.parseInt(sc.next())); // 机Aの冊数
		int m = new Integer(Integer.parseInt(sc.next())); // 机Bの冊数
		long k = new Integer(Integer.parseInt(sc.next())); // 読書時間
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Integer(Integer.parseInt(sc.next()));
		}
		long b[] = new long[m];
		for (int j = 0; j < m; j++) {
			b[j] = new Integer(Integer.parseInt(sc.next()));
		}

		int i = 0;
		int j = 0;
		while (0 <= k) {

			if (i == n && j != m) {

				// Aの机が空
				k -= b[j];
				j++;
				//System.out.println("あ " + i + " " + j + " " + k);

			} else if (i != n && j == m) {

				// Bの机が空
				k -= a[i];
				i++;
				//System.out.println("い " + i + " " + j + " " + k);

			} else if (i == n && j == m) {

				// もう本がない
				//System.out.println("う " + i + " " + j + " " + k);
				System.out.println(i + j);
				return;

			} else {

				if (a[i] <= b[j]) {

					// Aの机の本を読んで捨てる
					k -= a[i];
					i++;
					//System.out.println("え " + i + " " + j + " " + k);

				} else {

					// Bの机の本を読んで捨てる
					k -= b[j];
					j++;
					//System.out.println("お " + i + " " + j + " " + k);

				}

			}

		}

		System.out.println(i + j - 1);

	}
}
