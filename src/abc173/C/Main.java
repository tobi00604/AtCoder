package abc173.C;

import java.util.*;

// 【終了後のメモ】
// 全パターンを総当たりで調べれば解けるサイズの問題だと判断して実装した結果、一発正解できた。
// 解説PDFを読んでみると、全パターン総当たりという方針も正しかったし、
// 塗る/塗らない を 0/1 に置き換えて二進数っぽく考えるという発想も正しかったようだ。
// ただ、実装に１時間もかかり、正解時点で残り15分、他の問題を解く時間がなかった。
// １．二進数の各桁 0/1 をboolean値 true/false と見なして配列で管理したせいで、ソースが汚くなった
//     （シフト演算子（←よく分かってない）を使うともっとスマートにできたのかもしれない）
// ２．AtCoderでよく見かける、盤面を "." と "#" で表す入力に慣れていなかった
//     （こういった二次元盤面問題はABCだとE問題やF問題でよく見かける印象だが、まさかC問題に出るとは）
// これら２点が今回の敗因だと思う。他の正解者のソースコードを見るなどして勉強しようと思った。
public class Main {

	public static int i_max;
	public static int j_max;
	public static int field[][];
	public static boolean nurui[];
	public static boolean nuruj[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		i_max = Integer.parseInt(sc.next());
		j_max = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		field = new int[i_max][j_max];
		for (int i = 0; i < i_max; i++) {
			String s = sc.next();
			for (int j = 0; j < j_max; j++) {
				field[i][j] = (s.charAt(j) == '.') ? 0 : 1;
			}
		}

		nurui = new boolean[i_max];
		nuruj = new boolean[j_max];
		int answer = 0;

		for (int i = 0; i < (int) Math.pow(2, i_max); i++) {
			for (int j = 0; j < (int) Math.pow(2, j_max); j++) {

				// 塗りパターンを作る
				String bin_i = String.format("%0" + i_max + "d",
						Integer.valueOf(Integer.toBinaryString(i)));
				String bin_j = String.format("%0" + j_max + "d",
						Integer.valueOf(Integer.toBinaryString(j)));
				for (int p = 0; p < i_max; p++) {
					nurui[p] = (bin_i.charAt(p) == '0') ? false : true;
				}
				for (int p = 0; p < j_max; p++) {
					nuruj[p] = (bin_j.charAt(p) == '0') ? false : true;
				}

				// このパターンで塗ったときの黒マス数は、目標 k と一致するか？
				if (countBlack() == k) {
					answer++;
//					System.out.println(Arrays.toString(nurui));
//					System.out.println(Arrays.toString(nuruj));
//					System.out.println("");
				}

			}
		}

		// 出力
		System.out.println(answer);
		
	}

	// 現在のnurui, nurujで塗ったときの黒マス数
	private static int countBlack() {

		int result = 0;

		for (int i = 0; i < i_max; i++) {
			for (int j = 0; j < j_max; j++) {
				if (!nurui[i] && !nuruj[j] && field[i][j] == 1) {
					result++;
				}
			}
		}
		return result;

	}
}
