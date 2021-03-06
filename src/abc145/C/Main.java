package abc145.C;

import java.util.*;

public class Main {

	public static int n;
	public static ArrayList<Double> cost;
	public static double[] x;
	public static double[] y;

	public static double result1;
	public static int result2;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		x = new double[n];
		y = new double[n];
		for (int i = 0; i < n; i++) {
			x[i] = Double.parseDouble(sc.next());
			y[i] = Double.parseDouble(sc.next());
		}
		double[] cost = new double[1 << n];
		result1 = 0;
		result2 = 0;

		// ありえる道順の列挙を得つつ、コスト計算
		for (int i = 0; i < n; i++) {
			saiki(i + "");
		}

		System.out.println(result1 / (double) result2);
	}

	public static void saiki(String value) {

		// 距離計算して再帰打ち切り
		if (value.length() == n) {
			result1 += getTourCost(value);
			result2++;
			return;
		}

		// 次へ
		for (int i = 0; i < n; i++) {

			// すでに言った都市はスキップ
			if (value.contains(i + "")) {
				continue;
			}

			saiki(value + i);
		}
	}

	// 例えば route=="3142" だったら
	// 都市3⇒都市1⇒都市4⇒都市2
	// と座標を移動したときの合計距離を計算して返す
	public static double getTourCost(String route) {
		double sum = 0;
		for (int i = 0; i < n - 1; i++) {
			int from = route.charAt(i) - 48;
			int to = route.charAt(i + 1) - 48;
			double temp = 0;
			temp += ((x[to] - x[from]) * (x[to] - x[from]));
			temp += ((y[to] - y[from]) * (y[to] - y[from]));
			sum += Math.sqrt(temp);
		}
		return sum;
	}

}
