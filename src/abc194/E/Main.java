package abc194.E;

import java.util.*;

// 愚直にシミュレーション（誰でも思いつきそうな解法）でやってみる。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int answerMax = 0; // 答えは最大で何になるか
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			answerMax = Math.max(answerMax, a[i] + 1);
		}

		// 出現回数と現在のmex
		int[] counter = new int[answerMax + 2];
		Arrays.fill(counter, 0);
		int mex = 0;
		int mexmin = Integer.MAX_VALUE;

		// 最初の部分列とそのmex
		for (int i = 0; i < m; i++) {
			counter[a[i]]++;
		}
		while (counter[mex] != 0) {
			mex++;
		}
		mexmin = Math.min(mex, mexmin);

		// 確認用
//		System.out.println(Arrays.toString(counter));
//		System.out.println(mex);
//		System.out.println(mexmin);

		// 次以降
		for (int loop = 1; loop <= (n - m); loop++) {

			// 部分列が１個縮んで１個伸びる
			counter[a[loop - 1]]--;
			counter[a[loop + m - 1]]++;

			// mexがずれる
			if (counter[a[loop - 1]] == 0) {
				mex = a[loop - 1];
			} else {
				while (counter[mex] != 0) {
					mex++;
				}
			}

			// 最低記録更新
			mexmin = Math.min(mex, mexmin);

			// 確認用
//			System.out.println(Arrays.toString(counter));
//			System.out.println(mex);
//			System.out.println(mexmin);

			// 最低記録が 0 ならそれが答えで確定
			if (mexmin == 0) {
				System.out.println(0);
				return;
			}

		}

		// 結果出力
		System.out.println(mexmin);

	}
}
