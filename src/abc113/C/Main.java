package abc113.C;

import java.util.*;

// さっきの提出がTLEになったので、文字列連結をStringBuilderでやるように修正した。
// これでもTLEになったらどうしよう。
// Si型のオブジェクトを扱うのが遅いのか？
// Comparatorのソートが遅いのか？
// ちなみにACしている他の人のソースを見てみたらTreeMapでやってる人なら見た。
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		Si[] list = new Si[m];
		for (int i = 0; i < m; i++) {
			int p = Integer.parseInt(sc.next());
			int y = Integer.parseInt(sc.next());
			list[i] = new Si(i, p, y);
		}

		// p順になるようソート
		Comparator<Si> c = new Comparator<Si>() {
			public int compare(Si s1, Si s2) {
				if (s1.p == s2.p) {
					return s1.year - s2.year;
				}
				return s1.p - s2.p;
			}
		};
		Arrays.sort(list, c);

		// IDを作っていく
		int pNow = 0;
		int d = 0;
		for (Si s : list) {
			if (pNow != s.p) {
				d = 1;
				pNow = s.p;
			}
			s.id.append(makeStr(d));
			d++;
		}

		// out順になるようソート
		c = new Comparator<Si>() {
			public int compare(Si s1, Si s2) {
				return s1.out - s2.out;
			}
		};
		Arrays.sort(list, c);

		// 確認用
//		for (Si s : list) {
//			System.out.println(s.out + "_" + s.p + "_" + s.year + "_" + s.id);
//		}
//		System.out.println();

		// 出力
		for (Si s : list) {
			System.out.println(s.id);
		}

	}

	static class Si {
		int out;
		int p;
		int year;
		StringBuilder id;

		Si(int out, int p, int year) {
			this.out = out;
			this.p = p;
			this.year = year;
			this.id = new StringBuilder(makeStr(this.p));
		}
	}

	private static String makeStr(int i) {
		StringBuilder sb = new StringBuilder(Integer.toString(i));
		while (sb.length() < 6) {
			sb.insert(0, 0);
		}
		return sb.toString();
	}
}
