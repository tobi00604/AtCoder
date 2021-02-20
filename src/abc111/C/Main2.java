package abc111.C;

import java.util.*;

// /\/\/\/
// さっきの提出はWAになった。場合分けが複雑すぎてきついので
// 実際に数列を作ってみてコストを見る方法にしてみた。
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// 下段のリーダーとサブリーダー
		int[] count;
		count = new int[100001];
		for (int i = 0; i < n; i += 2) {
			count[a[i]]++;
		}
		int no1 = 0;
		int no1count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no1count < count[i]) {
				no1count = count[i];
				no1 = i;
			}
		}
		int no2 = 0;
		int no2count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no2count < count[i] && i != no1) {
				no2count = count[i];
				no2 = i;
			}
		}

		// 上段のリーダーとサブリーダー
		count = new int[100001];
		for (int i = 1; i < n; i += 2) {
			count[a[i]]++;
		}
		int no3 = 0;
		int no3count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no3count < count[i]) {
				no3count = count[i];
				no3 = i;
			}
		}
		int no4 = 0;
		int no4count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no4count < count[i] && i != no3) {
				no4count = count[i];
				no4 = i;
			}
		}

//		System.out.println(no1 + "が" + no1count + "個");
//		System.out.println(no2 + "が" + no2count + "個");
//		System.out.println(no3 + "が" + no3count + "個");
//		System.out.println(no4 + "が" + no4count + "個");

		// いろいろ作ってみて最も安いやつでいいのでは
		int minCost = Integer.MAX_VALUE;
		minCost = Math.min(f(a, no1, no3), minCost);
		minCost = Math.min(f(a, no2, no3), minCost);
		minCost = Math.min(f(a, no1, no4), minCost);
		minCost = Math.min(f(a, no2, no4), minCost);
		minCost = Math.min(f(a, no1, 0), minCost);
		minCost = Math.min(f(a, no2, 0), minCost);
		minCost = Math.min(f(a, 0, no3), minCost);
		minCost = Math.min(f(a, 0, no4), minCost);
		System.out.println(minCost);

	}

	// 作ってみる
	static int f(int[] a, int x, int y) {

		if (x == y) {
			return Integer.MAX_VALUE;
		}

		int cost = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				cost += (a[i] != x) ? 1 : 0;
			} else {
				cost += (a[i] != y) ? 1 : 0;
			}
		}
		return cost;

	}
}
