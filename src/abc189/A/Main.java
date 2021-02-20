package abc189.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		boolean a1 = str.charAt(0) == str.charAt(1);
		boolean a2 = str.charAt(1) == str.charAt(2);
		boolean a3 = str.charAt(2) == str.charAt(0);
		System.out.println((a1 && a2 && a3) ? "Won" : "Lost");

	}
}
