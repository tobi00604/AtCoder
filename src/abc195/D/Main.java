package abc195.D;

import java.util.*;

// いい戦術が分からん。価値が高いものから箱に入れる貪欲法をとりあえずやってみる。
// 
// さっきの提出では下記２つのミスがあったため修正。
// ・大きさが同じ荷物が複数あるケースを考慮していなかった
// ・クエリを処理するたびに変数初期化すべきなのを忘れていた
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 荷物数
		int m = Integer.parseInt(sc.next()); // 箱数
		int q = Integer.parseInt(sc.next()); // クエリの数
		Item[] item = new Item[n];
		for (int i = 0; i < n; i++) {
			int w = Integer.parseInt(sc.next());
			int v = Integer.parseInt(sc.next());
			item[i] = new Item(w, v);
		}
		Box[] box = new Box[m];
		for (int i = 0; i < m; i++) {
			int id = i + 1;
			int size = Integer.parseInt(sc.next());
			box[i] = new Box(id, size);
		}
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = Integer.parseInt(sc.next());
			r[i] = Integer.parseInt(sc.next());
		}

		// 荷物は価値の高いもの優先でソート
		// 箱は大きさの小さいもの優先でソート
		Comparator<Item> c1 = new Comparator<Item>() {
			public int compare(Item s1, Item s2) {
				if (s2.v == s1.v) {
					return s2.w - s1.w;
				}
				return s2.v - s1.v;
			}
		};
		Arrays.sort(item, c1);
		Comparator<Box> c2 = new Comparator<Box>() {
			public int compare(Box s1, Box s2) {
				return s1.size - s2.size;
			}
		};
		Arrays.sort(box, c2);

		// Q個のクエリ
		for (int query = 0; query < q; query++) {

			// 変数初期化
			long result = 0;
			for (int j = 0; j < m; j++) {
				box[j].ok = true;
			}

			// 各荷物について
			for (int i = 0; i < n; i++) {
//				System.out.println("大きさ" + item[i].w + "(価値" + item[i].v + ")は");

				// 箱を小さいものから見ていって、入れられる箱があったら入れる
				for (int j = 0; j < m; j++) {
					if (l[query] <= box[j].id && box[j].id <= r[query]) {
						continue;
					}
					if (item[i].w <= box[j].size && box[j].ok == true) {
//						System.out.println("箱" + box[j].id + "(大きさ" + box[j].size + ")に入った。");
						result += item[i].v;
						box[j].ok = false;
						break;
					}
				}
			}

			// こたえ
			System.out.println(result);
		}

	}

	static class Item {
		int w; // 大きさ
		int v; // 価値

		Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	static class Box {
		int id; // 番号
		int size; // 大きさ
		boolean ok; // 使用可能か

		Box(int id, int size) {
			this.id = id;
			this.size = size;
			this.ok = true;
		}
	}
}
