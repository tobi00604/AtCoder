package introHeuristics.A;

// 当プログラムについて備考
// 26種類をローテーション開催するだけの超簡単スケジュール。とりあえず動くものを提出したかったので。
// ちなみに提出結果は13639点。終了後の順位表を見ると13639点の人が大勢いた。やはりみんな思いつくローテーション。

import java.util.*;

public class Main {

	public static int span; // 何日間のスケジューリングをするか
	public static int minus[]; // 26種類のコンテストの飽きやすさ
	public static int plus[][]; // 26種類のコンテストの満足感

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		span = Integer.parseInt(sc.next()); // 何日間のスケジューリングをするか
		minus = new int[26]; // 26種類のコンテストの飽きやすさ
		for (int i = 0; i < 26; i++) {
			minus[i] = Integer.parseInt(sc.next());
		}
		plus = new int[span][26]; // 26種類のコンテストの満足感
		for (int d = 0; d < span; d++) {
			for (int i = 0; i < 26; i++) {
				plus[d][i] = Integer.parseInt(sc.next());
			}
		}

		// 適当にスケジュールを作って提出してみる

		// 26種類のコンテストを順番に開催
		int input1[] = new int[span];
		for (int d = 0; d < span; d++) {
			input1[d] = (d % 26) + 1;
		}
		int output1 = calc(input1);
		// System.out.println("満足度結果： "output1);

		for (int d = 0; d < span; d++) {
			System.out.println(input1[d]);
		}

	}

	public static int calc(int[] input) {

		int last[] = new int[26]; // 各コンテストが最終開催日から何日経過しているか
		int result = 0; // ユーザ満足度

		for (int d = 0; d < span; d++) {

			// lastの更新
			for (int i = 0; i < 26; i++) {
				if (i == input[d] - 1) {
					last[i] = 0;
				} else {
					last[i]++;
				}
			}

			// 開催による満足度アップ
			result += plus[d][input[d] - 1];

			// 日数経過による満足度ダウン
			for (int i = 0; i < 26; i++) {
				result -= minus[i] * last[i];
			}
		}

		return result;
	}
}
