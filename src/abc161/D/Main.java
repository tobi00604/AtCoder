package abc161.D;

import java.util.*;

// DFS(深さ優先探索)の練習。
public class Main {

	// すべてのルンルン数を入れるリスト
	public static ArrayList<Long> lunlun;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());

		lunlun = new ArrayList<Long>();
		saiki(1);
		saiki(2);
		saiki(3);
		saiki(4);
		saiki(5);
		saiki(6);
		saiki(7);
		saiki(8);
		saiki(9);

		// できあがったリストの中身ソート
		Collections.sort(lunlun);

		// リストの中身を全列挙
		for (long p : lunlun) {
			//System.out.println(p);
		}

		// k番目に小さいルンルン数を求めよ
		System.out.println(lunlun.get(k - 1));
	}

	// 引数で与えられたルンルン数をリストに入れて、次の探索へ進む関数
	public static void saiki(long value) {

		// リストに格納
		lunlun.add(value);

		// 問題の制約上、ルンルン数の桁数は11桁未満なので、11桁になりそうな場合は打ち切り
		if (1000000000 <= value) {
			return;
		}

		// 次へ
		if (value % 10 == 0) {
			saiki(value * 10);
			saiki(value * 10 + 1);
		} else if (value % 10 == 9) {
			saiki(value * 10 + 8);
			saiki(value * 10 + 9);
		} else {
			saiki(value * 10 + value % 10 - 1);
			saiki(value * 10 + value % 10);
			saiki(value * 10 + value % 10 + 1);
		}
	}

}
