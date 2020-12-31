package introHeuristics.A;

// 当プログラムについて備考
// 0点の原因を探るべく、貪欲法を「1日目から365日目まで」ではなく「3日目だけ」に適用してみた。
// 提出したところ9309点。0点にはならなかったということは先ほどの0点の原因はやはり 1～365 のループ？
// ていうか9309点って、初期値（ローテーション開催の13639点）より悪化してるじゃん…なぜだ…。
// 謎が謎を呼んでしまったのでもっといろいろ調べたかったが、今日はもう時間切れ。
 
import java.util.*;

public class Main3 {

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

		// ３日目を変えて満足度最大のものを探す
		int bestKaisai = 1;
		long bestScore = -99999;
		for (int i = 0; i < 26; i++) {

			teishutu[2] = i + 1;
			long score = calc(teishutu);
			// System.out.println(Arrays.toString(teishutu) + "\t" + score);

			if (score > bestScore) {
				bestKaisai = i + 1;
				bestScore = score;
			}
		}
		teishutu[2] = bestKaisai;

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
