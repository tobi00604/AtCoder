package abc180.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 整数ひとつ標準入力
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());

		// 約数リスト作成
		ArrayList<Long> list = getDivisorList(a);

		// 結果
		for (long b : list) {
			System.out.println(b);
		}

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
