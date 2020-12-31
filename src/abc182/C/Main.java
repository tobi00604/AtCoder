package abc182.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int sum = 0;
		int one = 0;
		int two = 0;
		for (int i = 0; i < s.length(); i++) {

			int p = s.charAt(i) - 48;
			sum += p;

			if (p % 3 == 1) {
				one++;
			}

			if (p % 3 == 2) {
				two++;
			}

		}

		// ‰½‚à‚µ‚È‚­‚Ä‚à‚R‚Ì”{”
		if (sum % 3 == 0) {
			System.out.println(0);
			return;
		}

		// ‘S•”‘«‚µ‚½‚ç‚P—]‚Á‚½ê‡
		if (sum % 3 == 1) {

			if (one != 0 && one < s.length()) {
				// 1,4,7‚ª‚ ‚Á‚½‚È‚ç‚»‚ê‚ðÁ‚¹‚Î‰ðŒˆ
				System.out.println(1);
				return;
			} else {
				// 2,5,8‚ª2‚Â‚ ‚Á‚½‚È‚ç‚»‚ê‚ç‚ðÁ‚¹‚Î‰ðŒˆ
				if (2 <= two && two < s.length()) {
					System.out.println(2);
					return;
				} else {
					System.out.println(-1);
					return;
				}
			}

		}

		// ‘S•”‘«‚µ‚½‚ç‚Q—]‚Á‚½ê‡
		if (sum % 3 == 2) {

			if (two != 0 && two < s.length()) {
				// 2,5,8‚ª‚ ‚Á‚½‚È‚ç‚»‚ê‚ðÁ‚¹‚Î‰ðŒˆ
				System.out.println(1);
				return;
			} else {
				// 1,4,7‚ª2‚Â‚ ‚Á‚½‚È‚ç‚»‚ê‚ç‚ðÁ‚¹‚Î‰ðŒˆ
				if (2 <= one && one < s.length()) {
					System.out.println(2);
					return;
				} else {
					System.out.println(-1);
					return;
				}
			}

		}

	}
}
