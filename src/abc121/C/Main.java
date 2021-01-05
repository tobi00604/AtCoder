package abc121.C;

import java.util.*;

//出典: AtCoder Beginner Contest 121 C - Energy Drink Collector
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		Shop s[] = new Shop[n];
		for (int i = 0; i < n; i++) {
			int price = Integer.parseInt(sc.next());
			int zaiko = Integer.parseInt(sc.next());
			s[i] = new Shop(price, zaiko);
		}

		// ソートの規則を作る
		Comparator<Shop> c = new Comparator<Shop>() {
			public int compare(Shop s1, Shop s2) {

				// 価格の安い順
				return s1.price - s2.price;

			}
		};

		// ソート（オブジェクト単位のソートなので配列aと連動して配列bも変化）
		Arrays.sort(s, c);

		// 確認用
		// for (int i = 0; i < n; i++) {
		// System.out.println(s[i].price + " " + s[i].zaiko);
		// }

		// 答えを求める
		long cost = 0;
		for (int i = 0; i < n; i++) {

			if (s[i].zaiko < m) {
				// この店のドリンクを買い占め
				m -= s[i].zaiko;
				cost += (long) s[i].zaiko * (long) s[i].price;
			} else {
				cost += (long) m * (long) s[i].price;
				System.out.println(cost);
				return;
			}
		}

	}
}

class Shop {

	int price; // ドリンクの値段
	int zaiko; // ドリンクの在庫

	// コンストラクタ
	public Shop(int price, int zaiko) {
		this.price = price;
		this.zaiko = zaiko;
	}
}
