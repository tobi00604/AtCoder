package abc160.E;

import java.util.*;

// 解説を読んでからやってみた
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int[] p = new int[a];
		int[] q = new int[b];
		int[] r = new int[c];
		for (int i = 0; i < a; i++) {
			p[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < b; i++) {
			q[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < c; i++) {
			r[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(p);
		Arrays.sort(q);
		Arrays.sort(r);

		// 食べるかもしれないリンゴだけを取り出して新しい配列に入れる
		int[] eat = new int[x + y + c];
		int j = 0;
		for (int i = 0; i < x; i++, j++) {
			eat[j] = p[a - 1 - i];
		}
		for (int i = 0; i < y; i++, j++) {
			eat[j] = q[b - 1 - i];
		}
		for (int i = 0; i < c; i++, j++) {
			eat[j] = r[c - 1 - i];
		}

		// 赤色緑色無色のリンゴ全部ごっちゃまぜでソート
		Arrays.sort(eat);

		// 確認用
		for (int i = 0; i < x + y + c; i++) {
			// System.out.println(eat[i]);
		}

		// おいしいほうから食べる
		long result = 0;
		for (int i = 0; i < x + y; i++) {
			result += eat[x + y + c - 1 - i];
		}

		System.out.println(result);
	}
}
