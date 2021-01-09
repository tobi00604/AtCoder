package abc180.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long x = Long.parseLong(sc.next());
		long y = Long.parseLong(sc.next());
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		// コーナーケース
		if (y < x * a && y < x + b) {
			System.out.println(0);
			return;
		}

		// aを使うかbを使うかの境界線
		long line = b / (a - 1);

		// 目標の強さがline以下の場合はa倍だけを使う
		if (y <= line) {
			long result = 0;
			while (x < y) {
				x *= a;
				result++;
			}
			System.out.println(result - 1);
			return;
		}

		// 初期の強さがlineより大きい場合はb加算だけを使う
		if (line < x) {
			long result = 0;
			result = (y - x) / b;
			if ((y - x) % b == 0) {
				result--;
			}
			System.out.println(result);
			return;
		}

		// 強さがline以下のときはaを使い、bを使ってlineを超え、そのまま目標寸前まで行く
		long result = 0;
		if (x == line) {
			x = Math.min(x * a, x + b);
			result++;
		}
		while (x < line) {
			x *= a;
			result++;
		}
		x /= a;
		result--;
		result += ((y - x) / b);
		if ((y - x) % b == 0) {
			result--;
		}
		System.out.println(result);
	}
}
