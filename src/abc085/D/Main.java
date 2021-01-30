package abc085.D;

import java.util.*;

// 試作品プログラム。とりあえずKatanaクラスとかソートとか作っただけ。提出はしない。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long hp = Long.parseLong(sc.next());
		int[] a = new int[n];
		int[] b = new int[n];
		Katana[] k = new Katana[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
			k[i] = new Katana(a[i], b[i]);
		}

		// aの中の最高威力を求める
		int maxA = 0;
		for (int i = 0; i < n; i++) {
			maxA = Math.max(a[i], maxA);
		}

		// 投げた時の威力が強い順にソートしておく
		Comparator<Katana> c = new Comparator<Katana>() {
			public int compare(Katana task1, Katana task2) {
				if (task1.b == task2.b) {
					return task2.a - task1.a;
				}
				return task2.b - task1.b;
			}
		};
		Arrays.sort(k, c);

		// 確認用
		System.out.println(maxA);
		for (int i = 0; i < n; i++) {
			System.out.println(k[i].toString());
		}

		// これ以降、投げてもmaxAより弱い刀は一切使わない

		// すべての刀をまず投げる
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (maxA < b[i]) {
				result++;
				hp -= b[i];
				if (hp <= 0) {
					System.out.println(result);
					return;
				}
			}
		}
		
		// あとはmaxAを振り続ける
		while(true){
			result++;
			hp -= maxA;
			if (hp <= 0) {
				System.out.println(result);
				return;
			}
		}
	}

	static class Katana {

		int a;
		int b;

		// コンストラクタ
		public Katana(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public String toString() {
			return this.a + " " + this.b;
		}
	}
}
