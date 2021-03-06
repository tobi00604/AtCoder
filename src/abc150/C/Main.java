package abc150.C;

import java.util.*;

// 順列全探索の練習
public class Main {

	public static int n;
	public static ArrayList<String> tour;

	public static void main(String[] args) {

		// 入力（都市の数）
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());

		// 入力（この問題特有の入力）
		String p = "";
		String q = "";
		for (int i = 0; i < n; i++) {
			p += (Integer.parseInt(sc.next()) - 1) + "";
		}
		for (int i = 0; i < n; i++) {
			q += (Integer.parseInt(sc.next()) - 1) + "";
		}

		// 順列列挙（都市0〜都市n-1を巡る）
		tour = new ArrayList<String>();
		for (int start = 0; start < n; start++) {
			saiki(start + "");
		}

		// 確認用
		// for (String walk : tour) {
		// System.out.println(walk);
		// }

		// 問題を解く
		String[] a = new String[tour.size()];
		int index = 0;
		for (String walk : tour) {
			a[index] = walk;
			index++;
		}
		Arrays.sort(a);
		int result = 0;
		for (int i = 0; i < tour.size(); i++) {
			if (a[i].equals(p)) {
				result += i + 1;
			}
			if (a[i].equals(q)) {
				result -= i + 1;
			}
		}
		System.out.println(Math.abs(result));

	}

	// 順列列挙用の再帰関数
	public static void saiki(String walk) {

		// 道順をリストに入れて再帰打ち切り
		if (walk.length() == n) {
			tour.add(walk);
			return;
		}

		// 次の都市（まだ通ってない都市）へ
		for (int i = 0; i < n; i++) {
			if (!walk.contains(i + "")) {
				saiki(walk + i);
			}
		}
	}
}