package sumitrust2019.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String s = sc.next();

		ArrayList<String> dic = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					StringBuilder r = new StringBuilder("");
					r.append(s.substring(i, i + 1));
					r.append(s.substring(j, j + 1));
					r.append(s.substring(k, k + 1));
					if (!dic.contains(r.toString())) {
						dic.add(r.toString());
					}
				}
			}
		}
		
		System.out.println(dic.size());

	}
}
