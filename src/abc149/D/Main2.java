package abc149.D;

import java.util.*;

// 前回の提出はWAになったので
// 貪欲法を配列のうしろから走らせていく戦術を追加してみる
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int rScore = Integer.parseInt(sc.next());
		int sScore = Integer.parseInt(sc.next());
		int pScore = Integer.parseInt(sc.next());
		String s = sc.next(); // 強弱はr⇒s⇒p⇒r
		char[] aiteHand = new char[n];
		for (int i = 0; i < n; i++) {
			aiteHand[i] = s.charAt(i);
		}

		// 貪欲法で自分の出す手を決めていく
		int[] myScore = new int[n];
		for (int i = 0; i < n; i++) {

			if (aiteHand[i] == 'r') {
				if (i < k) {
					myScore[i] = pScore;
				} else {
					myScore[i] = myScore[i - k] == pScore ? 0 : pScore;
				}
			} else if (aiteHand[i] == 's') {
				if (i < k) {
					myScore[i] = rScore;
				} else {
					myScore[i] = myScore[i - k] == rScore ? 0 : rScore;
				}
			} else if (aiteHand[i] == 'p') {
				if (i < k) {
					myScore[i] = sScore;
				} else {
					myScore[i] = myScore[i - k] == sScore ? 0 : sScore;
				}
			}

		}
		long result1 = 0;
		for (int i = 0; i < n; i++) {
			result1 += (long) myScore[i];
		}

		// 相手の出す手を反転
		char[] temp = new char[n];
		for (int i = 0; i < n; i++) {
			temp[i] = aiteHand[i];
		}
		for (int i = 0; i < n; i++) {
			aiteHand[i] = temp[n - 1 - i];
		}

		// もう一度貪欲法
		myScore = new int[n];
		for (int i = 0; i < n; i++) {

			if (aiteHand[i] == 'r') {
				if (i < k) {
					myScore[i] = pScore;
				} else {
					myScore[i] = myScore[i - k] == pScore ? 0 : pScore;
				}
			} else if (aiteHand[i] == 's') {
				if (i < k) {
					myScore[i] = rScore;
				} else {
					myScore[i] = myScore[i - k] == rScore ? 0 : rScore;
				}
			} else if (aiteHand[i] == 'p') {
				if (i < k) {
					myScore[i] = sScore;
				} else {
					myScore[i] = myScore[i - k] == sScore ? 0 : sScore;
				}
			}

		}
		long result2 = 0;
		for (int i = 0; i < n; i++) {
			result2 += (long) myScore[i];
		}

		// 通常版と反転版で結果が良かったほうを出力
		System.out.println(Math.max(result1, result2));

	}
}
