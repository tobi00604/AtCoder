package abc152.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int max = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.next());
			if (a < max) {
				max = a;
				result++;
			}
		}
		System.out.println(result);
	}
}
