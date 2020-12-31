package abc176.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		long result = 0;
		for (int i = 0; i < s.length(); i++) {
			String str = s.charAt(i) + "";
			result += Integer.valueOf(str);
		}

		System.out.println(result % 9 == 0 ? "Yes" : "No");

	}
}
