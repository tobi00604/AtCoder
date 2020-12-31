package abc172.C;

import java.util.*;

// 2020/7/7　ABC172から１週間以上経ったけど再挑戦
public class Main4 {

	public static int n;
	public static int m;
	public static long k;
	public static long a_sum[];
	public static long b_sum[];

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		n = new Integer(Integer.parseInt(sc.next())); // 机Aの冊数
		m = new Integer(Integer.parseInt(sc.next())); // 机Bの冊数
		k = new Integer(Integer.parseInt(sc.next())); // 読書時間
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Integer(Integer.parseInt(sc.next()));
		}
		long b[] = new long[m];
		for (int j = 0; j < m; j++) {
			b[j] = new Integer(Integer.parseInt(sc.next()));
		}

		// 累積和を作る。a_sum[i]は、机Aの本をi冊読んだときにかかる時間
		a_sum = new long[n + 1];
		for (int i = 0; i < n + 1; i++) {
			if (i != 0) {
				a_sum[i] = a_sum[i - 1] + a[i - 1];
			} else {
				a_sum[i] = 0;
			}
			//System.out.print(a_sum[i] + ", ");
		}
		log("");
		b_sum = new long[m + 1];
		for (int j = 0; j < m + 1; j++) {
			if (j != 0) {
				b_sum[j] = b_sum[j - 1] + b[j - 1];
			} else {
				b_sum[j] = 0;
			}
			//System.out.print(b_sum[j] + ", ");
		}
		log("");

		// 机Aをi冊読んだとしたら机Bは何冊読めるか、を全iについて調べる
		int highscore = 0;
		for (int i = 0; i < n + 1; i++) {

			// すでに時間オーバーの場合
			if (k < a_sum[i]) {
				continue;
			}

			int score = check(i);
			if (highscore < score) {
				highscore = score;
			}
		}

		System.out.println(highscore);

	}

	public static int check(int i) {

		// 机A終了時点の残り時間
		long zan = k - a_sum[i];

		log("★机Aを" + i + "冊読んだ。あと" + zan + "分残っている。");

		// 机Bを1冊も読むことができない場合
		if (zan < b_sum[0]) {
			log("⇒机Bを1冊も読むことができない");
			return i;
		}

		// 机Bが1冊だけの場合
		if (m == 0) {
			log("⇒机Bが1冊だけ");
			return i + 1;
		}

		// 机Bを全冊読める場合
		if (b_sum[m] <= zan) {
			log("⇒机Bを全冊読める");
			return i + m;
		}

		// 以下、b_sum[]から探す。普通に探すとΟ(m)かかるけど二分探索ならΟ(logm)で済む。
		// 探すのは「c冊読んだけどもう1冊読むとオーバーする」ようなc。
		int l = 0;
		int r = m;
		int c;

		while (true) {

			// cの目星を付ける。lとrの中間あたりとする。これが二分探索。
			c = l + ((r - l) / 2);

			// 見つけた場合
			if (b_sum[c] <= zan && zan < b_sum[c + 1]) {
				log("⇒机Bは" + c + "冊読める");
				return i + c;
			}

			// まだまだ時間が余っている場合
			if (b_sum[c] < zan) {
				log("　机Bを" + c + "冊読んでも時間がまだ余っている");
				l = c;
			}

			// すでにオーバーしている場合
			if (zan < b_sum[c]) {
				log("　机Bを" + c + "冊読むとオーバーしてしまう");
				r = c;
			}

		}
	}

	public static void log(String str) {
		//System.out.println(str);
	}
}
