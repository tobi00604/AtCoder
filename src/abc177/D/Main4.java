package abc177.D;

import java.util.*;

public class Main4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int friends[];
		friends = new int[n + 1];

		// 入力を配列に持つ
		String line[];
		line = new String[m];
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			line[i] = Math.min(a, b) + "_" + Math.max(a, b);
		}
		Arrays.sort(line);

		// 確認用
		for (int i = 0; i < m; i++) {
			System.out.println(line[i]);
		}

		// friends[77]には出席番号77番の人の友達の数が入る
		for (int i = 0; i < m; i++) {

			// 不要な情報であればスキップ
			if (i != 0 && line[i].equals(line[i - 1])) {
				continue;
			}

			friends[Integer.valueOf(line[i].split("_")[0])]++;
			friends[Integer.valueOf(line[i].split("_")[1])]++;
		}

		// 確認用
		for (int i = 1; i < n + 1; i++) {
			System.out.println(i + " " + friends[i]);
		}

		// 最も友達が多い人は、何人友達がいるか？
		int best = 0;
		for (int i = 1; i < n + 1; i++) {
			if (best < friends[i]) {
				best = friends[i];
			}
		}

		// 最も友達が多い人の、友達の数が500人だったら、501グループに分断する
		System.out.println(best + 1);

	}
}
