package abc107.C;

import java.util.*;

// 原点から K+1 以上離れているろうそくは行っても無意味。コスト計算をスキップしていい。
// ところが前回の提出ではそのスキップ処理にバグがあってWAになってしまった。
// そこで下記のロジックは、安全第一として、無意味なコスト計算もあえてやるロジックとなっている。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		long[] x = new long[n];
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}

		// 全探索
		int left = 0;
		int right = k - 1;
		long cost;
		long minCost = -1;
		while (true) {

			right = left + k - 1;

			if (right == n) {
				break;
			}

			cost = Math.abs(x[left]) + Math.abs(x[left] - x[right]);
			if (cost < minCost || minCost == -1) {
				minCost = cost;
			}

			cost = Math.abs(x[right]) + Math.abs(x[left] - x[right]);
			if (cost < minCost) {
				minCost = cost;
			}

			left++;
		}

		System.out.println(minCost);
	}
}
