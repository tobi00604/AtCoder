package abc170.D;

import java.util.*;

// TLEになるロジックだが自分の到達点として提出
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int a[] = new int[n];
		boolean b[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = true;
		}
		Arrays.sort(a);

		// アイテムが１個だけなら答えは 1 のはず
		if (n == 1) {
			System.out.println(1);
			return;
		}

		// ループ
		for (int i = 0; i < n; i++) {

			// 同じ数が再登場したときの処理
			if (i != 0 && a[i - 1] == a[i]) {
				b[i - 1] = false;
			}

			if (b[i]) {
				for (int j = i + 1; j < n; j++) {
					if (b[j] && a[j] % a[i] == 0) {
						b[j] = false;
						System.out.println(a[j] + " は" + a[i] + "により除外");
					}
				}
			}
		}

		// 結果
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (b[i]) {
				result++;
			}
		}
		System.out.println(result);

	}
}
