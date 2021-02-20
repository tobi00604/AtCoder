package abc111.C;

import java.util.*;

// /\/\/\/ 
public class Main {

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

		// 下段も上段も統一済み
		if (no2 == 0 && no4 == 0) {
			if (no1 == no3) {
				System.out.println(n / 2);
				return;
			} else {
				System.out.println(0);
				return;
			}
		}

		// 下段が統一済み
		if (no2 == 0) {
			if (no1 == no3) {
				System.out.println((n / 2) - no4count);
				return;
			} else {
				System.out.println((n / 2) - no3count);
				return;
			}
		}

		// 上段が統一済み
		if (no4 == 0) {
			if (no1 == no3) {
				System.out.println((n / 2) - no2count);
				return;
			} else {
				System.out.println((n / 2) - no1count);
				return;
			}
		}

		// 上段も下段もいじる必要がある
		if (no1 == no3) {
			System.out.println(Math.min((no1count + no4count), (no2count + no3count)));
			return;
		} else {
			System.out.println(no2count + no4count);
			return;
		}

	}
}
