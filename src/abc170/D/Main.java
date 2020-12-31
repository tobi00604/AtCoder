package abc170.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // アイテム数
		int x[] = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(x);

		// やりやすくするためにリストにする
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (!list.contains(x[i])) {
				list.add(x[i]);
			}
		}

		// アイテムが１個だけなら答えは 0 のはず…？
		if (list.size() <= 1) {
			System.out.println(0);
			return;
		}

		// ループ
		int i = 0;
		while (i < list.size()) {

			int base = list.get(i);

			// 倍数を取り除いていく
			int j = i + 1;
			while (j < list.size()) {

				int val = list.get(j);

				//System.out.println(list.toString());
				
				if (val % base == 0) {
					// 取り除く場合
					//System.out.println(base + "と" + val + "→倍数なので除去");
					list.remove(j);
				} else {
					// 取り除かない場合
					//System.out.println(base + "と" + val + "→倍数でないので次");
					j++;
				}

			}

			// 次へ
			i++;

		}

		// 結果
		System.out.println(list.size());

	}
}
