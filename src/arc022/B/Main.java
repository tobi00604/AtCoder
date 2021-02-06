package arc022.B;

import java.util.*;

// 細長いお菓子

// しゃくとり法をちゃんと作ったのにさっきの提出はTLEになった。
// ArrayListが重いのかも？そこでHashSet（順序は覚えないし重複は入らない集合）で代用してみる。
// 余談１：HashSetで順序を覚えたい場合はLinkedHashSetを使うといいらしいけど処理遅くならないかな。
// 余談２：https://java-reference.com/java_collection_compare.html
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// しゃくとり法
		HashSet<Integer> set = new HashSet<>();
		long result = 0;
		int l = 0;
		int r = 0;
		while (l < n) {

			// 行けるところまで右手を進める
			// System.out.println(l + "_" + r);
			while (r < n && !set.contains(a[r])) {
				set.add(a[r]);
				r++;
				// System.out.println(Arrays.toString(set.toArray()));
			}
			// System.out.println(l + "_" + r);

			// ハイスコア記録
			result = Math.max(result, set.size());

			// 左手を動かす
			if (l == r) {
				// 左手と一緒に右手も動かすとき
				l++;
				r++;
				// System.out.println("右手もひとつ進めました");
			} else {
				// ふつうに左手がひとつ進むとき
				l++;
				set.remove(a[l - 1]);
				// System.out.println("setから" + a[l - 1] + "を削除しました");
			}
		}

		System.out.println(result);
	}
}
