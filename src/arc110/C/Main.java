package arc110.C;

import java.util.*;

// n-1箇所のスワップを１回ずつ使って、長さnの配列をソートする問題。

// あちこち詰めが甘い気はするが、とりあえずできたので提出。
// O(n^2)やってるのでTLEになる気もする。いちおう入出力例は全部通る。

// 提出後のメモ：
// やはりTLEだった。でも方針は合ってた。あとは工夫して計算量をO(n)に落とせばいい！
// なお緑Diff(1100)である。方針は分かりやすいし思い付きやすいので、実装の重さか。
public class Main {

	static int[] p;
	static boolean[] used;
	static List<Integer> output;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		p = new int[n];
		used = new boolean[n];
		output = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
			used[i] = false;
		}

		// 大きい数字から順に後ろへ運んでいく
		for (int target = n; target > 0; target--) {
			for (int i = 0; i < target - 1; i++) {
				// ターゲットを見つけたらスワップ
				if (p[i] == target) {
					if (!swap(i, i + 1)) {
						// 使用済みのスワップをまた使ったら答えは-1
						System.out.println(-1);
						return;
					}
				}
			}
		}

		// すべてのスワップを使い切ってない場合も答えは-1
		if (output.size() != n - 1) {
			System.out.println(-1);
			return;
		}

		// 結果出力
		for (int z : output) {
			System.out.println(z);
		}
	}

	static boolean swap(int a, int b) {

		if (used[a]) {
			return false;
		}

		output.add(a + 1);

		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
		used[a] = true;
		return true;
	}
}
