package m_solutions2020.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int p[];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
		}

		// 所持金と所持株
		int money = 1000;
		int kabu = 0;

		// 10株持ってるけど売るのはあえて7株にして手元に3株残しておくとか、
		// 3000円持ってるけど買うのはあえて500円分にして手元に2500円残しておくとか、
		// そういうことは考えず、買うときは全購入、売るときは全売却とする。
		// このやりかたで不正解だったら考え直そう。

		for (int i = 0; i < n; i++) {

			int saiyasu = 9999;
			for (int j = i; j < n; j++) {

				//System.out.println("j " + j);

				if (p[j] < saiyasu) {
					saiyasu = p[j];
					//System.out.println("★" + saiyasu);
				}

				// 株価が前日より上がったとき
				if (j != 0 && p[j - 1] < p[j]) {
					kabu = money / saiyasu;
					money -= kabu * saiyasu;
					money += kabu * p[j];
					//System.out.println("取引 " + j + " " + kabu + " " + money);
					i = j;
					break;
				}
			}
		}
		System.out.println(money);

	}

}
