package abc174.D;

import java.util.*;

// 【ABC174終了後の感想】
// Cは、10分考えてもアイデアが浮かばないのでスキップ。
// Eは、30分考えた結果、貪欲法（最も長い丸太を半分に切る）で答えが出せそうだという結論には至ったが、
// 問題のサイズが大きすぎて貪欲法だと実行時間オーバーしそうなので、悔しいがスキップ。
// 上記のCとEを考える時間が長すぎた！残り50分しかないじゃん！大急ぎでDに着手、残り時間ぎりぎりで正解。
// もしDが間に合ってなかったら、危うくAとBの2完で終わるところだった。時間配分気を付けよう。
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String str = sc.next();

		int result = 0;

		int l = 0;
		int r = n - 1;

		while (true) {

			// 最も左にある 'W' を探す
			while (true) {
				if (str.length() == l) {
					break;
				}
				if (str.charAt(l) == 'W') {
					break;
				}
				l++;
			}

			// 最も右にある 'R' を探す
			while (true) {
				if (r == -1) {
					break;
				}
				if (str.charAt(r) == 'R') {
					break;
				}
				r--;
			}

			//System.out.println("swap! " + " " + l + " " + r);

			// 次へ
			if (l > r) {
				break;
			}
			result++;
			l++;
			r--;
		}

		System.out.println(result);

	}
}
