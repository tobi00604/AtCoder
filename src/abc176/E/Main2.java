package abc176.E;

import java.util.*;

// 「最も爆破対象が多い行を探してすべて燃やし、次に最も爆破対象が多い列を探してすべて燃やす」
// というロジックを作ったが、テストケース130個のうち5個がWA、コンテスト時間内にACできなかった。
// 「最も箱が多い行または列」が複数ヒットしたときどうするかを考慮していなかったので、再挑戦。
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		Box[] box = new Box[m];
		for (int i = 0; i < m; i++) {
			int h_ = Integer.parseInt(sc.next());
			int w_ = Integer.parseInt(sc.next());
			box[i] = new Box(h_, w_);
		}

		// 各行（または列）に爆破対象はいくつあるか
		int[] hCount = new int[h + 1];
		int[] wCount = new int[w + 1];
		for (int i = 0; i < m; i++) {
			hCount[box[i].h]++;
			wCount[box[i].w]++;
		}

		// 最も多くある行（または列）番号と、爆破対象個数をまとめてMapへ
		HashSet<Integer> hKouho = new HashSet<>();
		int hMax = -1;
		for (int i = 1; i < h + 1; i++) {
			hMax = Math.max(hMax, hCount[i]);
		}
		for (int i = 1; i < h + 1; i++) {
			if (hMax == hCount[i]) {
				hKouho.add(i);
			}
		}
		HashSet<Integer> wKouho = new HashSet<>();
		int wMax = -1;
		for (int i = 1; i < w + 1; i++) {
			wMax = Math.max(wMax, wCount[i]);
		}
		for (int i = 1; i < w + 1; i++) {
			if (wMax == wCount[i]) {
				wKouho.add(i);
			}
		}

		// 爆弾を置きたいマスは hKouho.size() * wKouho.size() ヶ所ある
		// ※30万と30万の掛け算はintの範囲を超えるので型変換が必要
		long hKouhoNum = Long.parseLong(hKouho.size() + "");
		long wKouhoNum = Long.parseLong(wKouho.size() + "");
		long wannaPlace = hKouhoNum * wKouhoNum;

		// 爆破対象がないマスに爆弾を置くことができると、答えが１増える
		for (int i = 0; i < m; i++) {
			if (hKouho.contains(box[i].h) && wKouho.contains(box[i].w)) {
				wannaPlace--;
			}
		}
		if (0 < wannaPlace) {
			System.out.println(hMax + wMax);
		} else {
			System.out.println(hMax + wMax - 1);
		}
	}

	// m個の爆破対象
	static class Box {
		int h;
		int w;

		Box(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}
}
