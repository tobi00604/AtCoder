package abc172.C;

import java.util.*;

// Mainが不正解になるのでやり直してみる。提出時はクラス名をMainにすること
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = new Integer(Integer.parseInt(sc.next())); // 机Aの冊数
		int m = new Integer(Integer.parseInt(sc.next())); // 机Bの冊数
		long k = new Integer(Integer.parseInt(sc.next())); // 読書時間

		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrayA.add(new Integer(Integer.parseInt(sc.next())));
		}

		ArrayList<Integer> arrayB = new ArrayList<Integer>();
		for (int j = 0; j < m; j++) {
			arrayB.add(new Integer(Integer.parseInt(sc.next())));
		}

		int loop = 0;
		while (true) {

			if (arrayA.size() == 0 && arrayB.size() == 0) {
				System.out.println(loop);
				return;
			} else if (arrayB.size() == 0) {
				k -= arrayA.get(0);
				arrayA.remove(0);
			} else if (arrayA.size() == 0) {
				k -= arrayB.get(0);
				arrayB.remove(0);
			} else {
				if (arrayA.get(0) < arrayB.get(0)) {
					k -= arrayA.get(0);
					arrayA.remove(0);
				} else {
					k -= arrayB.get(0);
					arrayB.remove(0);
				}
			}

			// 読書時間を使い切ったら
			if (k < 0) {
				System.out.println(loop);
				return;
			}

			// 次の本へ
			loop++;
		}

	}
}
