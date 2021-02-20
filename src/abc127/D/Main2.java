package abc127.D;

import java.util.*;

// さっきの提出、発想は正しかったと思う（WAがなかったので）けど、REとTLEが多発。
// 初期カードと追加カードをまとめてひとつの配列にしたら長すぎたんだと思う。
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		Kakikae[] kk = new Kakikae[m];
		for (int i = 0; i < m; i++) {
			int times = Integer.parseInt(sc.next());
			int newVal = Integer.parseInt(sc.next());
			kk[i] = new Kakikae(newVal, times);
		}

		// 初期カードは昇順に、追加カードは降順にソートしておく
		Arrays.sort(a);
		Comparator<Kakikae> c = new Comparator<Kakikae>() {
			public int compare(Kakikae x, Kakikae y) {
				return y.newVal - x.newVal;
			}
		};
		Arrays.sort(kk, c);

		// n個取る
		long result = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (kk.length != j) {
				result += Math.max(a[i], kk[j].newVal);
				kk[j].times--;
				if (kk[j].times == 0) {
					j++;
				}
			} else {
				result += a[i];
			}
		}
		System.out.println(result);

	}

	static class Kakikae {
		int newVal;
		int times;

		Kakikae(int newVal, int times) {
			this.newVal = newVal;
			this.times = times;
		}
	}

}
