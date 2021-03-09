package abc144.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long m = Long.parseLong(sc.next());

		// ありえるマスを全探索
		long minCost = Long.MAX_VALUE;
		ArrayList<Long> list = getDivisorList(m);
		for (long i : list) {

			// 座標と移動コスト
			long x = i;
			long y = m / i;
			long cost = x + y - 2;
			minCost = Math.min(cost, minCost);

		}

		System.out.println(minCost);

	}

	// 引数で与えられた整数の約数リストを作成して返す
	public static ArrayList<Long> getDivisorList(long a) {

		ArrayList<Long> list = new ArrayList<Long>();
		for (long i = 1; i * i <= a; i++) {
			if (a % i == 0) {
				list.add(i);
				if (!list.contains(a / i)) {
					list.add(a / i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
}
