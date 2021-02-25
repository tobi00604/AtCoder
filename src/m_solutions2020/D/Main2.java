package m_solutions2020.D;

import java.util.*;

// ‰ğà‚ğ“Ç‚ñ‚Å‚©‚ç‚â‚Á‚Ä‚İ‚½
public class Main2 {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] p = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = Long.parseLong(sc.next());
		}

		// Š‹à‚ÆŠŠ”
		long money = 1000;
		long kabu = 0;

		for (int i = 0; i < n; i++) {

			// ‚Ü‚¸‘S•””„‚é
			money += p[i] * kabu;
			kabu = 0;

			// –¾“ú‚Ì‚Ù‚¤‚ª‚‚¢‚Æ‚«‚Í‘SàY‚©‚¯‚Ä”ƒ‚¤
			if (i != n - 1 && p[i] < p[i + 1]) {
				long kau = money / p[i];
				money -= kau * p[i];
				kabu += kau;
			}
		}

		System.out.println(money);

	}

}
