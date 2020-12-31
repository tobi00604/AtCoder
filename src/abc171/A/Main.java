package abc171.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		String komoji = s.toLowerCase();

		if (s.equals(komoji)) {
			System.out.println("a");
		} else {
			System.out.println("A");
		}

	}
}
