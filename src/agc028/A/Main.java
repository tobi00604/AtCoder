package agc028.A;

import java.util.*;

// 解き方に自信がないけどとりあえず実装したので提出。
// (問題ページに書いてある入出力例1～3はいちおうすべて通る）
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int gcd = getTwoGcd(n, m);
		int lcm = (n / gcd) * m;
		String s = sc.next();
		String t = sc.next();

		int i = 0;
		int j = 0;
		boolean[] match = new boolean[gcd];
		for (int index = 0; index < gcd; index++) {

			// 両方の略語が共有している文字が一致しているか比較
			match[index] = (s.charAt(i) == t.charAt(j));

			// 入力が15と9だったら、iは3ずつ、jは5ずつ増加
			i += n / gcd;
			j += m / gcd;
		}

		// 確認用
		// System.out.println(Arrays.toString(match));

		for (int level = 0; level < match.length + 1; level++) {

			// マッチ配列を見ていく
			boolean successFlg = true;
			for (int p = 1; p < gcd; p++) {

				// 判定
				if (!match[p]) {
					successFlg = false;
					break;
				}

				// レベルによってはpを一気に飛ばしていい
				p += level;
			}

			if (successFlg) {
				System.out.println(lcm * (level + 1));
				return;
			}
		}

		System.out.println(-1);
		return;
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
