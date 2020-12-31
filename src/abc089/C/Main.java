package abc089.C;

import java.util.*;

// ‚³‚Á‚«‚Ì’ño‚ªWA‚É‚È‚é‚Ì‚Å‚Æ‚è‚ ‚¦‚¸int‚ğlong‚É‚µ‚Ä‚İ‚é
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long a[];
		a = new long[5];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			if (str.matches("M.*")) {
				a[0]++;
			}
			if (str.matches("A.*")) {
				a[1]++;
			}
			if (str.matches("R.*")) {
				a[2]++;
			}
			if (str.matches("C.*")) {
				a[3]++;
			}
			if (str.matches("H.*")) {
				a[4]++;
			}
		}

		long result = 0;

		result += a[0] * a[1] * a[2];
		result += a[0] * a[1] * a[3];
		result += a[0] * a[1] * a[4];
		result += a[0] * a[2] * a[3];
		result += a[0] * a[2] * a[4];
		result += a[0] * a[3] * a[4];
		result += a[1] * a[2] * a[3];
		result += a[1] * a[2] * a[4];
		result += a[1] * a[3] * a[4];
		result += a[2] * a[3] * a[4];
		System.out.println(result);

	}
}
