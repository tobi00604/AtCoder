package abc098.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String inputStr = sc.next();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = inputStr.charAt(i) == 'E' ? 1 : -1;
		}

		// 例えば最も左の人をリーダーにした場合
		int cost = 0;
		for (int i = 0 + 1; i < n; i++) {
			cost += a[i] == 1 ? 1 : 0;
		}
		int minCost = cost;

		// 全探索
		for (int i = 0 + 1; i < n; i++) {

			// リーダーは振り返らなくていい
			if (a[i] == 1) {
				cost--;
			}

			// 前回リーダーだった人が振り返るかもしれない
			if (a[i - 1] == -1) {
				cost++;
			}

			// コストの最小値（答え）は覚えておく
			if (cost < minCost) {
				minCost = cost;
			}

		}

		System.out.println(minCost);

	}
}
