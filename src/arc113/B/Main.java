package arc113.B;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = (int) Long.parseLong(sc.next()) % 10;
		int b = (int) Long.parseLong(sc.next()) % 100;
		int c = (int) Long.parseLong(sc.next()) % 100;

		BigInteger bb = BigInteger.valueOf(b);
		BigInteger z = bb.pow(c);

		if (z.compareTo(BigInteger.ZERO) == 0) {
			System.out.println(1);
			return;
		}

		z = z.remainder(BigInteger.valueOf(4));
		int s = Integer.parseInt(z.toString());

		// a‚Ì‰ºˆêŒ…‚Æs‚É‚æ‚Á‚Ä“š‚¦‚ÍŒˆ‚Ü‚é
		if (a == 0) {
			int ans[] = { 0, 0, 0, 0 };
			System.out.println(ans[s]);
		}
		if (a == 1) {
			int ans[] = { 1, 1, 1, 1 };
			System.out.println(ans[s]);
		}
		if (a == 2) {
			int ans[] = { 6, 2, 4, 8 };
			System.out.println(ans[s]);
		}
		if (a == 3) {
			int ans[] = { 1, 3, 9, 7 };
			System.out.println(ans[s]);
		}
		if (a == 4) {
			int ans[] = { 6, 4, 6, 4 };
			System.out.println(ans[s]);
		}
		if (a == 5) {
			int ans[] = { 5, 5, 5, 5 };
			System.out.println(ans[s]);
		}
		if (a == 6) {
			int ans[] = { 6, 6, 6, 6 };
			System.out.println(ans[s]);
		}
		if (a == 7) {
			int ans[] = { 1, 7, 9, 3 };
			System.out.println(ans[s]);
		}
		if (a == 8) {
			int ans[] = { 6, 8, 4, 2 };
			System.out.println(ans[s]);
		}
		if (a == 9) {
			int ans[] = { 1, 9, 1, 9 };
			System.out.println(ans[s]);
		}

	}
}
