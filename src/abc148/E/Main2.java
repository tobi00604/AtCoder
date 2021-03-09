package abc148.E;

import java.util.*;

// 解説を読んでからやってみた
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// コーナーケース。nが奇数だと答えは0で確定
		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}

		// f(n)の末尾に0がいくつあるか求めたい
		// ↓
		// f(n)を何回5で割り切れるか求める
		// ↓
		// f(n)を5で割り切れる回数と
		// f(n)を5^2で割り切れる回数と
		// …
		// f(n)を5^30で割り切れる回数の和
		// ↓
		// n以下の偶数で5^1で割り切れるものの個数と
		// n以下の偶数で5^2で割り切れるものの個数と
		// …
		// n以下の偶数で5^30で割り切れるものの個数の和
		// ↓
		// n以下の整数で10(=2*5^1)の倍数の個数と
		// n以下の整数で50(=2*5^2)の倍数の個数と
		// …
		// n以下の整数で??(=2*5^30)の倍数の個数の和

		long result = 0;
		long warukazu = 2 * 5;
		for (int i = 1; i <= 30; i++) {

			// n以下の整数で 2*5^i の倍数の個数
			long ans = n / warukazu;

			if (ans == 0) {
				break; // 中断条件
			} else {
				result += ans;
				warukazu *= 5;
			}

		}
		System.out.println(result);

	}

}
