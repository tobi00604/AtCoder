package abc151.C;

import java.util.*;

// 前々回の提出→問題ごとの不正解数を保持していないバグあり
// 前回の提出→バグは直したけどTLEになる。リストがダメか？
// 今回→リストではなく配列にした。ACなるか？
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] p = new int[m];
		int[] s = new int[m];
		for (int i = 0; i < m; i++) {
			p[i] = Integer.parseInt(sc.next());
			s[i] = (sc.next().equals("AC") ? 1 : 0);
		}

		// 問題ごとのAC状況
		int[] ac = new int[100001];
		// 問題ごとのWA回数
		int[] miss = new int[100001];

		long result1 = 0;
		long result2 = 0;

		for (int i = 0; i < m; i++) {

			// 正解済みの問題に対する提出は無視
			if (ac[p[i]] == 1) {
				continue;
			}

			if (s[i] == 1) {
				result1++;
				result2 += miss[p[i]];
				ac[p[i]]++;
			} else {
				miss[p[i]]++;
			}

		}

		System.out.println(result1 + " " + result2);
	}
}
