package abc085.D;

import java.util.*;

// さっきの提出がWAだったので解説PDFを読んでしまった。
// ・投げると強い刀を全部投げてから、振ると強い刀を振り続ける、という戦略は正しかった！
// ・さっきの提出では投げる刀のソートを忘れていた。修正した。今度こそACなるか？
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int hp = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// aの中の最高威力を求める
		int maxA = 0;
		for (int i = 0; i < n; i++) {
			maxA = Math.max(a[i], maxA);
		}

		// これ以降、投げてもmaxAより弱い刀は一切使わない

		// すべての刀をまず投げる
		Arrays.sort(b);
		int result = 0;
		for (int i = n - 1; 0 <= i; i--) {
			if (maxA < b[i]) {
				result++;
				hp -= b[i];
				if (hp <= 0) {
					System.out.println(result);
					return;
				}
			}
		}

		// あとはmaxAを振り続ける
		result += hp / maxA + (hp % maxA != 0 ? 1 : 0);
		System.out.println(result);
	}
}
