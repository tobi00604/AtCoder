package abc176.E;

import java.util.*;

// ＜終了後の感想＞
// 縦横に炎が伸びる爆弾を１個置いて、なるべくたくさんの箱を燃やす問題。箱があるマスにも爆弾を置ける。
// そこで「最も箱が多い行を探してすべて燃やし、次に最も箱が多い列を探してすべて燃やす」という
// ロジックを作ったが、テストケース130個のうち5個が不正解、結局時間内に正解できず。
// コンテスト終了後に気付いたが、「最も箱が多い行」が複数ヒットしたときどうするかを考慮していなかった。
// 例えば以下の入力のとき、正しい答えは3だが、このロジックだと2が出力されてしまう。
// 3 2 3
// 2 2
// 1 1
// 3 1
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h_input = Integer.parseInt(sc.next());
		int w_input = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		int hCount[];
		hCount = new int[300001];
		int wCount[];
		wCount = new int[300001];
		int hInput[];
		hInput = new int[300001];
		int wInput[];
		wInput = new int[300001];

		// 箱位置情報
		for (int i = 0; i < m; i++) {
			hInput[i] = Integer.parseInt(sc.next());
			wInput[i] = Integer.parseInt(sc.next());
		}

		// 行ごとに箱を数える
		for (int i = 0; i < m; i++) {
			hCount[hInput[i]]++;
		}

		// どの行に爆弾を置くかを決めよう
		int h_max_index = 1;
		int h_max = 0;
		for (int i = 1; i < 300001; i++) {
			if (h_max < hCount[i]) {
				h_max = hCount[i];
				h_max_index = i;
			}
		}
		// System.out.println("最も箱が多い行　" + h_max_index);
		// System.out.println("その行の箱の数　" + h_max);

		// 列ごとに箱を数える
		// （ただしさっき爆弾を置くことにした行にある箱はスルー）
		for (int i = 0; i < m; i++) {
			if (hInput[i] != h_max_index) {
				wCount[wInput[i]]++;
			}
		}

		// どの列に爆弾を置くかを決めよう
		int w_max_index = 1;
		int w_max = 0;
		for (int i = 1; i < 300001; i++) {
			if (w_max < wCount[i]) {
				w_max = wCount[i];
				w_max_index = i;
			}
		}
		// System.out.println("最も箱が多い列　" + w_max_index);
		// System.out.println("その列の箱の数　" + w_max);

		// 結果出力
		System.out.println(h_max + w_max);
	}
}
