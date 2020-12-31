package arc109.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int r = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// ˜L‰º‚P‰ñ
		if (a == b || a == b + 1) {
			System.out.println(r);
			return;
		}

		// ‚Ğ‚Æ‚Â‚Ìƒrƒ‹“à‚Å‚PƒtƒƒAã‰º‚·‚éÅ’ZŠÔ
		int f = Math.min(r + r, k);

		// ‚±‚½‚¦
		if (a < b) {
			System.out.println(f * (b - a) + r);
		} else {
			System.out.println(f * (a - b - 1) + r);
		}
	}
}
