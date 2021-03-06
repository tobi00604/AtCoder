package abc187.C;

import java.util.*;

// さきほど提出したArrayListのプログラムだとTLEになるのでHashSetでやってみた
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			set.add(sc.next());
		}

		// 判定
		for (String s : set) {
			if (set.contains("!" + s)) {
				System.out.println(s);
				return;
			}
		}

		System.out.println("satisfiable");
	}
}
