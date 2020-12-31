package abc169.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// nが1だったら答えは0で確定
		if (n == 1) {
			System.out.println(0);
			return;
		}

		// nを素因数分解
		HashMap<Long, Long> map = primeFactorize(n);

		// 素因数分解の結果表示
		for (long key : map.keySet()) {
			// System.out.println(key + "^" + map.get(key));
		}

		// 結果を求めて出力
		int result = 0;
		for (long key : map.keySet()) {
			long z = map.get(key);
			for (int j = 1; j < 10000; j++) {
				if (j <= z) {
					z -= j;
					result++;
				} else {
					break;
				}
			}
		}

		System.out.println(result);

	}

	// nを素因数分解して、結果用mapに素因数と指数のペアを入れて返す関数。
	public static HashMap<Long, Long> primeFactorize(long n) {

		long input = n;
		HashMap<Long, Long> map = new HashMap<Long, Long>();

		// nが0以下だったらnullを返す
		if (n <= 0) {
			return null;
		}

		// 本来はおかしい入力だが、nが1だったら素因数分解結果は1^1とする
		if (n == 1) {
			map.put(1L, 1L);
			return map;
		}

		// 素因数分解していく。計算量はO(√n)
		for (long i = 2; i * i <= input; i++) {
			long j = 0;
			while (true) {
				if (n % i == 0) {
					j++;
					map.put(i, j);
					n /= i;
				} else {
					break;
				}
			}
		}

		// 最後に残った数も忘れずに入れる
		if (n != 1) {
			map.put(n, 1L);
		}

		return map;
	}
}