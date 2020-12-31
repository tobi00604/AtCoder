package chokudai002.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		long[] result = new long[100];
		long p = 1;
		for (int i = 0; i < 100; i++) {
			long a = 1;
			while (true) {
				if (a > 1000000000 / p) {
					result[i] = a;
					break;
				}
				p++;
				a *= p;
			}
			System.out.println(a);
		}
	}
}
