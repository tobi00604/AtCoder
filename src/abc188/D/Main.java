package abc188.D;

import java.util.*;

// いもす法。高さC以上の山は削って高さCにできる
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long mountain = Long.parseLong(sc.next());

		Stop[] sim = new Stop[n * 2];
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			long c = Long.parseLong(sc.next());

			sim[i] = new Stop(a, c);
			sim[n + i] = new Stop(b + 1, -1 * c);
		}

		// 日付順にソート
		Comparator<Stop> c = new Comparator<Stop>() {
			public int compare(Stop p, Stop q) {
				if (p.day == q.day) {
					return (q.zougen - p.zougen > 0) ? -1 : 1;
				}
				return (p.day - q.day > 0) ? 1 : -1;
			}
		};
		Arrays.sort(sim, c);

		// 確認用
//		for (Stop s : sim) {
//			System.out.println(s.day + " " + s.zougen);
//		}

		// 総額計算
		long result = 0;
		long onedaycost = 0;
		for (int i = 0; i < n * 2 - 1; i++) {

			onedaycost += sim[i].zougen;
			long temp1 = sim[i + 1].day - sim[i].day;
			long temp2 = Math.min(onedaycost, mountain);
//			System.out.println(sim[i + 1].day + "～" + sim[i].day + " " + temp2
//					+ "円");
			result += temp1 * temp2;
		}

		System.out.println(result);

	}

	static class Stop {
		long day;
		long zougen;

		// コンストラクタ
		public Stop(long day, long zougen) {
			super();
			this.day = day;
			this.zougen = zougen;
		}
	}
}
