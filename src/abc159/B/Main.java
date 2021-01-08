package abc159.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();

		String a = s.substring(0, (n - 1) / 2);
		String b = s.substring((n + 1) / 2);

		System.out.println(a.equals(b) ? "Yes" : "No");
	}
}
