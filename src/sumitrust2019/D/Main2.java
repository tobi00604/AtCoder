package sumitrust2019.D;

import java.util.*;

// ‚³‚Á‚«’ño‚µ‚½‚Ì‚ªTLE‚É‚È‚Á‚½‚Ì‚Å•¶š—ñ‘€ì‚ğ‚µ‚È‚¢‚æ‚¤C³
// ‚Å‚àŒ‹‹Ç‚n(n^3)‚¾‚©‚çƒ_ƒ‚©‚àH
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String s = sc.next();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(s.substring(i, i + 1));
		}

		ArrayList<Integer> dic = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int r = a[i] * 100 + a[j] * 10 + a[k];
					if (!dic.contains(r)) {
						dic.add(r);
					}
				}
			}
		}

		System.out.println(dic.size());

	}
}
