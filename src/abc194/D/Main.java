package abc194.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		// つまりこの問題、クーポンコレクター問題の答えから1引いた結果を
		// 出力すればいいのでは？
		double d = 0.0;
		for (int i = 1; i <= n; i++) {
			d += 1.0D / (double) i;
		}
		System.out.println(d * (double) n - 1.0D);

	}
}
