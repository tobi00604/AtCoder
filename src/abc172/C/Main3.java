package abc172.C;

import java.util.*;

// Main2が相変わらず不正解、しかもTLEになる。Mainより悪化してる。やり直してみる。提出時はクラス名をMainにすること
public class Main3 {

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

		// リストの先頭を削除するのは遅いらしいのでリバースして末尾から削除するようにしよう
		// (TLE対策。不正解なのか変わらないと思うが)
		Collections.reverse(arrayA);
		Collections.reverse(arrayB);

		int loop = 0;
		while (true) {

			if (arrayA.size() == 0 && arrayB.size() == 0) {
				System.out.println(loop);
				return;
			} else if (arrayB.size() == 0) {
				k -= arrayA.get(arrayA.size() - 1);
				arrayA.remove(arrayA.size() - 1);
			} else if (arrayA.size() == 0) {
				k -= arrayB.get(arrayB.size() - 1);
				arrayB.remove(arrayB.size() - 1);
			} else {
				if (arrayA.get(arrayA.size() - 1) < arrayB.get(arrayB.size() - 1)) {
					k -= arrayA.get(arrayA.size() - 1);
					arrayA.remove(arrayA.size() - 1);
				} else {
					k -= arrayB.get(arrayB.size() - 1);
					arrayB.remove(arrayB.size() - 1);
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
