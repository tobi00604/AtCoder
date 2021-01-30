package abc168.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		String s = sc.next();

		if (s.length() <= k) {
			System.out.println(s);
			return;
		}

		System.out.println(s.substring(0, k) + "...");
	}

}