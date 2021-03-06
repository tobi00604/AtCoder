package abc191.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// 結果出力
		StringBuilder resultStr = new StringBuilder();
		resultStr.append("");
		boolean first = true;
		for (int i = 0; i < n; i++) {
			if (a[i] != x) {
				resultStr.append(first ? a[i] : " " + a[i]);
				first = false;
			}
		}

		System.out.println(resultStr);

	}
}
