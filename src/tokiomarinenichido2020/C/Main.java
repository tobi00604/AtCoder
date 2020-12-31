package tokiomarinenichido2020.C;

import java.util.Scanner;

public class Main {

	// ★コンテスト終了後の所感　ここから
	// 各座標がどれくらいの明るさなのか、素直に数え上げる方法でやった結果、実行時間制約超過に…。
	// 解説PDFおよび動画によると、電球が照らす区間に着目し、明るさの増減を表す数列Pを作るとよいらしい。
	// （例えば数列Pの5番目が-1だったら、座標4に比べて座標5は1段階暗くなった、ということ）
	// すると、数列Pの「累積和」にあたる数列Qを求めるだけで、Qがそのままこの問題の答えになるのである。
	// 詳しくは「累積和」や「いもす法」でググること。今後のAtCoderで使えそうな知識だと思った。
	// ★コンテスト終了後の所感　ここまで

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 電球の個数
		int k = Integer.parseInt(sc.next()); // 操作回数
		int x[] = new int[n + 1]; // 光の強さ
		for (int i = 1; i <= n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}

		// 当たっている光の数を配列にする
		int light[] = new int[n + 1];

		// 操作をk回やる
		for (int loop = 0; loop < k; loop++) {

			// 当たっている光の数を配列にする
			for (int i = 1; i <= n; i++) {
				light[i] = 0;
			}

			// 各々の電球について
			for (int i = 1; i <= n; i++) {

				// 光を当てていく
				int left = Math.max(i - x[i], 1);
				int right = Math.min(i + x[i], n);
				for (int j = left; j <= right; j++) {
					light[j]++;
				}
				// System.out.println("電球" + i + "の照らす範囲→" + left + "～" +
				// right);
			}

			// 光の強さを更新
			System.arraycopy(light, 0, x, 0, x.length);

		}

		// 結果
		for (int i = 1; i <= n; i++) {
			System.out.print(x[i]);
			if (i < n) {
				System.out.print(" ");
			}
		}
	}

}
