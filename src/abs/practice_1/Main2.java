package abs.practice_1;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n[];
		n = new int[3];
		n[0] = Integer.parseInt(sc.next());
		n[1] = Integer.parseInt(sc.next());
		n[2] = Integer.parseInt(sc.next());
		String s = sc.next();

		// o—Í
		System.out.println((n[0] + n[1] + n[2]) + " " + s);

	}

}
