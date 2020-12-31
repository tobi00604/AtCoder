package abc172.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		int n = s.length();
		int result = 0;

		for (int i = 0; i <= n - 1; i++) {
			String a = s.substring(i, i + 1);
			String b = t.substring(i, i + 1);
			//System.out.println(a);
			//System.out.println(b);

			if (a.equals(b)) {
				//System.out.println("OK " + result);
			} else {
				result++;
				//System.out.println("NG " + result);
			}
		}

		System.out.println(result);

	}
}
