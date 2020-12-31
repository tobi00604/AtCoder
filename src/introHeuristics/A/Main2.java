package introHeuristics.A;

// 当プログラムについて備考
// 貪欲法らしきものを作ってみた。しかし何度提出しても0点。どこがおかしいのか…。

import java.util.*;

public class Main2 {

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

		// 提出用配列を初期化しておく（初期値はまぁ適当に26種類のコンテストをローテーション開催で）
		int teishutu[] = new int[span];
		for (int d = 0; d < span; d++) {
			teishutu[d] = (d % 26) + 1;
		}

		// 貪欲法をやってみよう（ちゃんと貪欲法になっているかは知らん）
		for (int d = 0; d < span; d++) {

			// d日目は何を開催したら満足度最大かを求めて、提出用配列をそれにする
			int bestKaisai = 1;
			long bestScore = -99999;
			for (int i = 0; i < 26; i++) {

				teishutu[d] = i + 1;
				long score = calc(teishutu);
				// System.out.println(Arrays.toString(teishutu) + "\t" + score);

				if (score > bestScore) {
					bestKaisai = i + 1;
					bestScore = score;
				}
			}
			teishutu[d] = bestKaisai;

		}

		// 提出
		for (int d = 0; d < span; d++) {
			System.out.println(teishutu[d]);
		}

	}

	public static long calc(int[] input) {

		int last[] = new int[26]; // 各コンテストが最終開催日から何日経過しているか
		long result = 0; // ユーザ満足度

		for (int d = 0; d < input.length; d++) {

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
				result -= (minus[i] * last[i]);
			}
		}

		return result;
	}
}
