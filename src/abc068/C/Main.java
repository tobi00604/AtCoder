package abc068.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// 最初の船で行ける島
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			if (a[i] == 1) {
				hs.add(b[i]);
			}
		}

		// 次の船で島nに行けるか
		for (int i = 0; i < m; i++) {
			if (hs.contains(a[i]) && b[i] == n) {
				System.out.println("POSSIBLE");
				return;
			}
		}
		System.out.println("IMPOSSIBLE");

	}
}
