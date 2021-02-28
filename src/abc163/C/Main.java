package abc163.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[200001];
		Arrays.fill(a, 0);
		for (int i = 1; i < n; i++) {
			int x = Integer.parseInt(sc.next());
			a[x]++;
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(a[i]);
		}

	}
}
