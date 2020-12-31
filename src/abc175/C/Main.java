package abc175.C;

import java.math.BigInteger;
import java.util.*;

// 終了後の感想
// now と dist * k の大きさ比較で苦戦したけど、解説PDFを見たら
// now / dist と k の大きさ比較してる…。このことになぜ気づかなかったのか…。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long now = Long.parseLong(sc.next());
		long k = Long.parseLong(sc.next());
		long dist = Long.parseLong(sc.next());

		// 現在地が負なら、正にして考えても同じこと
		if (now < 0) {
			now = -1 * now;
		}

		// なるべく0に近づくのが目的なので、0を通り過ぎたら折り返さなければならない。
		// そこでまずは「0を通り過ぎる」が発生するかどうかを判定する。
		// ただし、k（移動回数）とdist（１回の移動距離）が大きすぎるため、
		// k * dist の計算はBigIntegerを使う。（BigIntegerは今日初めて知った）
		BigInteger bigK = BigInteger.ONE.multiply(BigInteger.valueOf(k));
		BigInteger bigSeki = bigK.multiply(BigInteger.valueOf(dist));
		BigInteger bigNow = BigInteger.ONE.multiply(BigInteger.valueOf(now));
		BigInteger bigHoge = bigNow.subtract(bigSeki);
		int hikaku = bigHoge.compareTo(BigInteger.ZERO);

		// 移動回数を使い切っても0まで到達しないパターン
		if (hikaku == 1) {
			System.out.println(now - (k * dist));
			return;
		}

		// 移動を使い切ったときにぴったり0にゴールするパターン
		if (hikaku == 0) {
			System.out.println(0);
			return;
		}

		// 以下、0を通り過ぎるパターン

		// まず0の直前まで歩く
		k -= now / dist;
		now = now % dist;

		// 残り回数が偶数なら、現在地がゴール
		if (k % 2 == 0) {
			System.out.println(now);
			return;
		}

		// 残り回数が奇数なら、0を一度だけ通り過ぎて着いたところがゴール
		System.out.println(dist - now);

	}
}
