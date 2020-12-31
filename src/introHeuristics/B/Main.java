package introHeuristics.B;

// 2020.6.28
// https://atcoder.jp/contests/intro-heuristics
import java.util.*;

public class Main {

	public static int span; // 何日間のスケジューリングをするか
	public static int minus[]; // 26種類のコンテストの飽きやすさ
	public static int plus[][]; // 26種類のコンテストの満足感

	public static void main(String[] args) {

		// ----------
		// 入力
		// ----------
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

		// ----------
		// 入力(テストケース)
		// ----------
		int input[] = new int[span]; // 開催したコンテスト
		for (int d = 0; d < span; d++) {
			input[d] = Integer.parseInt(sc.next());
		}

		// ----------
		// 計算と出力
		// ----------
		calc(input);

	}

	public static void calc(int[] input) {

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
				// System.out.println("last[" + i + "] = " + last[i]);
			}

			// 開催による満足度アップ
			result += plus[d][input[d] - 1];

			// 日数経過による満足度ダウン
			for (int i = 0; i < 26; i++) {
				result -= minus[i] * last[i];
				// System.out.println(minus[i] * last[i]);
			}
			System.out.println(result);
		}
	}
}
