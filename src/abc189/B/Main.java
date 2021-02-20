package abc189.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long limit = Integer.parseInt(sc.next()) * 100;
		long alc = 0;
		for (int i = 1; i <= n; i++) {
			long v = Integer.parseInt(sc.next());
			long p = Integer.parseInt(sc.next());
			alc += v * p;
			if (limit < alc) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);

	}
}
