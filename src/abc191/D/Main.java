package abc191.D;

import java.util.*;

// 任意の円の内部に含まれる格子点を数える問題。
// ぐぐったらこんなページ（下記URL）を見つけたので丸パクリした。
// https://qiita.com/Tukaene/items/63b86d918e4924c12d36
// ところが問題ページの入出力例３を入れてみると、
// 出力は正しいけど出力されるまで1分以上かかるのでTLE確定。未提出。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		double x = Double.parseDouble(sc.next());
		double y = Double.parseDouble(sc.next());
		double r = Double.parseDouble(sc.next());

		int start = (int) Math.ceil(x - r);
		int end = (int) Math.floor(x + r);

		long result = 0;
		double p = 0;
		for (int i = start; i <= end; i++) {
			p = Math.sqrt(Math.pow(r, 2) - Math.pow((x - (double) i), 2));

			int bottom = (int) Math.ceil(y - p);
			int top = (int) Math.floor(y + p);

			for (int j = bottom; j <= top; j++) {
				result++;
			}
		}

		System.out.println(result);

	}
}
