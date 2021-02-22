package abc163.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// コーナーケース
		if (n + 1 == k) {
			System.out.println(1);
			return;
		}

		long hou = 1000000000 + 7;
		long result = 0;
		for (int mai = k; mai <= n + 1; mai++) {

			// 作れる和で最小のものと最大のもの
			long minWa = getSum(0, mai - 1);
			long maxWa = getSum(n - mai + 1, n);

			// mai枚とったときに作れるのはpat通り
			long pat = maxWa - minWa + 1;
			pat %= hou;
			result += pat;
			result %= hou;
		}

		System.out.println(result);
	}

	static long getSum(long from, long to) {
		return (from + to) * (to - from + 1) / 2;
	}
}
