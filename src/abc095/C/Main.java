package abc095.C;

import java.util.*;

// 提出後のメモ：
// この問題をやろうと思ったのは、下記ブログにて全探索の練習問題として紹介されていたから。
// https://qiita.com/e869120/items/eb50fdaece12be418faa
// 実際、解説PDFでも全探索が模範解答であるかのように書いてある。
// …ところが計算量Ｏ(1)の下記ソースコードで一発ACできてしまった。全探索はまた今度やってみよう。
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// AとBを直接買うと
		long result1 = a * x + b * y;

		// ABを買ってからAやBで補うと
		long result2;
		if (x < y) {
			result2 = c * x * 2 + b * (y - x);
		} else {
			result2 = c * y * 2 + a * (x - y);
		}

		// ABだけで済ませると
		long result3 = Math.max(x, y) * 2 * c;

		// 一番安い買い方が答え
		System.out.println(Math.min(result1, Math.min(result2, result3)));

	}
}
