package abc187.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		ArrayList<String> list = new ArrayList<String>();

		String result = "satisfiable";
		boolean endFlg = false;
		for (int i = 0; i < n; i++) {

			String str = sc.next();

			if (endFlg) {
				continue;
			}

			// 初登場ならリストに保持
			if (!list.contains(str)) {
				list.add(str);
			} else {
				continue;
			}

			// 判定
			if (str.charAt(0) == '!') {

				if (list.contains(str.substring(1))) {
					result = str.substring(1);
					endFlg = true;
				}

			} else {

				if (list.contains("!" + str)) {
					result = str;
					endFlg = true;
				}

			}

		}

		System.out.println(result);

	}
}
