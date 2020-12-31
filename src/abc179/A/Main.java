package abc179.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		System.out.println(a.matches(".*s") ? a + "es" : a + "s");
	}
}
