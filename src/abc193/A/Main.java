package abc193.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		double n = Double.parseDouble(sc.next());
		double m = Double.parseDouble(sc.next());

		double p = (1 - (m / n)) * 100;

		System.out.println(p);
	}
}
