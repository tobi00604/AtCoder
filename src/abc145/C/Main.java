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

		// “ü—Í
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

		// ‚ ‚è‚¦‚é“¹‡‚Ì—ñ‹“‚ð“¾‚Â‚ÂAƒRƒXƒgŒvŽZ
		for (int i = 0; i < n; i++) {
			saiki(i + "");
		}

		System.out.println(result1 / (double) result2);
	}

	public static void saiki(String value) {

		// ‹——£ŒvŽZ‚µ‚ÄÄ‹A‘Å‚¿Ø‚è
		if (value.length() == n) {
			result1 += getTourCost(value);
			result2++;
			return;
		}

		// ŽŸ‚Ö
		for (int i = 0; i < n; i++) {

			// ‚·‚Å‚ÉŒ¾‚Á‚½“sŽs‚ÍƒXƒLƒbƒv
			if (value.contains(i + "")) {
				continue;
			}

			saiki(value + i);
		}
	}

	// —á‚¦‚Î route=="3142" ‚¾‚Á‚½‚ç
	// “sŽs3Ë“sŽs1Ë“sŽs4Ë“sŽs2
	// ‚ÆÀ•W‚ðˆÚ“®‚µ‚½‚Æ‚«‚Ì‡Œv‹——£‚ðŒvŽZ‚µ‚Ä•Ô‚·
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
