package abc175.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String x = sc.next();

		if (x.equals("SSS")) {
			System.out.println(0);
			return;
		}

		if (x.equals("RSS")) {
			System.out.println(1);
			return;
		}

		if (x.equals("SRS")) {
			System.out.println(1);
			return;
		}

		if (x.equals("SSR")) {
			System.out.println(1);
			return;
		}

		if (x.equals("RRS")) {
			System.out.println(2);
			return;
		}

		if (x.equals("SRR")) {
			System.out.println(2);
			return;
		}

		if (x.equals("RSR")) {
			System.out.println(1);
			return;
		}

		if (x.equals("RRR")) {
			System.out.println(3);
			return;
		}

	}
}
