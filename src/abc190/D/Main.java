package abc190.D;

import java.util.*;

// 解説の一部だけをちょっと読んでからやってみた
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// 式 2n=(a+b)(b-a+1) が成り立つ。
		// (a+b)と(b-a+1)は2nの約数といえる。
		// そこで2nの約数を列挙
		ArrayList<Long> yakusuList = getDivisorList(2 * n);

		// 探索
		int result = 0;
		for (long i : yakusuList) {
			long j = 2 * n / i;

			// 連立方程式 a+b=i, b-a+1=j を解く
			long a = (i - j + 1) / 2;
			long b = (i + j - 1) / 2;

			// 確認用
//			System.out.println(i + "_" + j + " " + a + "～" + b);

			// 題意を満たすか確認してカウント
			if (2 * n == (a + b) * (b - a + 1)) {
				result++;
			}

		}

		// 結果
		System.out.println(result);

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
