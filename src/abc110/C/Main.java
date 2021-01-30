package abc110.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		for (int i = 0; i < a.length(); i++) {
			String x = a.charAt(i) + "";
			String y = b.charAt(i) + "";
			if (map1.containsKey(x)) {
				if (!map1.get(x).equals(y)) {
					System.out.println("No");
					return;
				}
			} else if (map2.containsKey(y)) {
				if (!map2.get(y).equals(x)) {
					System.out.println("No");
					return;
				}
			} else {
				map1.put(x, y);
				map2.put(y, x);
			}
		}

		System.out.println("Yes");
	}
}
