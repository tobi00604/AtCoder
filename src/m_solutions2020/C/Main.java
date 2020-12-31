package m_solutions2020.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int p[];
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(sc.next());
		}

		// ƒ‹[ƒv‚µ‚È‚ª‚ço—Í
		for (int i = k + 1; i <= n; i++) {

			int right = p[i];
			int left = p[i - k];
			System.out.println(left < right ? "Yes" : "No");
		}

	}

}
